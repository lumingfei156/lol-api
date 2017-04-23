package cn.howieli.lol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.service.IItemService;

@RequestMapping("/api")
@RestController
public class APIItemController {

	@Autowired
	private IItemService itemService;
	
	/**
	 * 获取所有装备信息
	 * @return
	 */
	@GetMapping("/getItems")
	public Message getItems() {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(itemService.getItems());
		return msg;
	}
	
	/**
	 * 通过id获取装备信息
	 * @return
	 */
	@GetMapping("/getItems/{id}")
	public Message getItemsById(@PathVariable int id) {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(itemService.getItemById(id));
		return msg;
	}
	
}
