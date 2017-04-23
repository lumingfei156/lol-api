package cn.howieli.lol.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.service.ICountService;

@RestController
@RequestMapping("/admin")
public class CountController {
	@Autowired
	private ICountService countService;
	
	@GetMapping("/getCount")
	public Message getCount() {
		Message msg = new Message();
		if (countService.selectToday() == null) {
			countService.insertToday();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("today", countService.selectToday().getApiNums());
		map.put("sevenDay", countService.select7Day());
		map.put("total", countService.getCountTotal());
		
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(map);
		return msg;
	}
	
}
