package cn.howieli.lol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.service.ISummonerSpellService;

@RequestMapping("/api")
@RestController
public class APISummonerSpellController {
	
	@Autowired
	private ISummonerSpellService summonerSpellService;
	
	/**
	 * 获取召唤师技能信息
	 * @return
	 */
	@GetMapping("/getSummonerSpells")
	public Message getSummonerSpells() {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(summonerSpellService.getSummonerSpells());
		return msg;
	}
	
	/**
	 * 通过id获取召唤师技能
	 * @param id
	 * @return
	 */
	@GetMapping("/getSummonerSpells/{id}")
	public Message getSummonerSpellById(@PathVariable String id) {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(summonerSpellService.getSummonerSpellById(id));
		return msg;
	}
	
}
