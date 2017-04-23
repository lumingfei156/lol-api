package cn.howieli.lol.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.model.Admin;
import cn.howieli.lol.model.ConstValue;
import cn.howieli.lol.service.IAdminService;
import cn.howieli.lol.service.IChampionService;
import cn.howieli.lol.service.IItemService;
import cn.howieli.lol.service.ISummonerSpellService;
import cn.howieli.lol.util.RandomStringUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;

	@Autowired
	private IChampionService championService;
	
	@Autowired
	private IItemService itemService;
	
	@Autowired
	private ISummonerSpellService summonerSpellService;
	
	/**
	 * 后台登录功能
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@ResponseBody
	@PostMapping("/login")
	public Message login(String username, String password, HttpSession session) {
		Message msg = new Message();
		Admin admin = adminService.login(username);
		if (admin == null || !admin.getPassword().equals(DigestUtils.md5Hex(password + admin.getSalt()))) {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject(MessageCode.FAILLY);
		} else {
			session.setAttribute(ConstValue.SessionName.SESSION_ADMIN, admin);
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject(MessageCode.SUCCESSFULLY);
		}
		return msg;
	}
	
	/**
	 * 获取管理员信息
	 * @param session
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getAdminInfo")
	public Message getAdminInfo(HttpSession session) {
		Message msg = new Message();
		Admin admin = (Admin) session.getAttribute(ConstValue.SessionName.SESSION_ADMIN);
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(admin);
		return msg;
	}
	
	/**
	 * 退出登录
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(Model model , HttpSession session) {
		model.asMap().remove(ConstValue.SessionName.SESSION_ADMIN);
		session.invalidate();
		return "redirect:";
	}
	
	/**
	 * 修改管理员信息
	 * @param admin
	 * @param newPassword
	 * @return
	 */
	@ResponseBody
	@PostMapping("/updateAdmin")
	public Message updateAdmin(Admin admin, @RequestParam(value = "newPassword", required = false) String newPassword, 
									Model model , HttpSession session) {
		Message msg = new Message();
		Admin adminSession = (Admin) session.getAttribute(ConstValue.SessionName.SESSION_ADMIN);
		Admin oldAdmin = adminService.login(adminSession.getUsername());
		if (oldAdmin.getPassword().equals(DigestUtils.md5Hex(admin.getPassword() + oldAdmin.getSalt()))) {
			if (admin.getUsername() == null || admin.getUsername() == "") {
				admin.setUsername(oldAdmin.getUsername());
			}
			if (admin.getNickname() == null || admin.getNickname() == "") {
				admin.setNickname(oldAdmin.getNickname());
			}
			if (!newPassword.equals("")) {
				admin.setSalt(RandomStringUtil.getRandomString(10));
				admin.setPassword(DigestUtils.md5Hex(newPassword + admin.getSalt()));
			} else {
				admin.setPassword(null);
			}
			admin.setId(oldAdmin.getId());
			if (adminService.updateAdmin(admin) != 1) {
				msg.setWhat(MessageCode.FAIL);
				msg.setObject("服务器发生未知错误");
			} else {
				model.asMap().remove(ConstValue.SessionName.SESSION_ADMIN);
				session.invalidate();
				msg.setWhat(MessageCode.SUCCESSFUL);
				msg.setObject(MessageCode.SUCCESSFULLY);
			}
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject("密码输入错误");
		}
		return msg;
	}
	
	/**
	 * 获取英雄，装备和召唤师技能总数
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getDataTotal")
	public Message getDataTotal() {
		Message msg = new Message();
		Map<String, Integer> totals = new HashMap<String, Integer>();
		totals.put("champion", championService.getTotal());
		totals.put("item", itemService.getTotal());
		totals.put("spell", summonerSpellService.getTotal());
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(totals);
		return msg;
	}
	
	/**
	 * 更新英雄数据
	 * @return
	 */
	@ResponseBody
	@GetMapping("/setChampionData")
	public Message setChampionData() {
		Message msg = new Message();
		if (championService.setChampionData()) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject("更新英雄数据成功");
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject("更新英雄数据失败");
		}
		return msg;
	}
	
	/**
	 * 更新装备数据
	 * @return
	 */
	@ResponseBody
	@GetMapping("/setItemData")
	public Message setItemData() {
		Message msg = new Message();
		if (itemService.setItemData()) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject("更新物品数据成功");;
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject("更新物品数据失败");
		}
		return msg;
	}
	
	/**
	 * 更新召唤师技能数据
	 * @return
	 */
	@ResponseBody
	@GetMapping("/setSummonerSpellData")
	public Message setSummonerSpellData() {
		Message msg = new Message();
		if (summonerSpellService.setSummonerSpellData()) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject("更新召唤师技能数据成功");
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject("更新召唤师技能数据失败");
		}
		return msg;
	}
	
}
