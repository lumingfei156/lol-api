package cn.howieli.lol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.service.IChampionService;

@RequestMapping("/api")
@RestController
public class APIChampionController {
	
	@Autowired
	private IChampionService championService;
	
	/**
	 * 获取所有英雄简略数据
	 * @return
	 */
	@GetMapping("/getBriefChampions")
	public Message getBriefChampions() {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(championService.getBriefChampions());
		return msg;
	}
	
	/**
	 * 通过id获取英雄简略信息
	 * @param id
	 * @return
	 */
	@GetMapping("/getBriefChampions/{id}")
	public Message getBriefChampionById(@PathVariable int id) {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(championService.getBriefChampionsById(id));
		return msg;
	}
	
	/**
	 * 获取所有英雄详细数据
	 * @return
	 */
	@GetMapping("/getChampions")
	public Message getChampions() {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(championService.getChampions());
		return msg;
	}
	
	/**
	 * 获取指定id的英雄详细数据
	 * @param id
	 * @return
	 */
	@GetMapping("/getChampions/{id}")
	public Message getChampionsById(@PathVariable int id) {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(championService.getChampionById(id));
		return msg;
	}
	
	/**
	 * 获取周免英雄
	 * @return
	 */
	@GetMapping("/getFreeChampions")
	public Message getFreeChampions() {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(championService.getFreeChampions());
		return msg;
	}
	
}
