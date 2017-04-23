package cn.howieli.lol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.model.Area;
import cn.howieli.lol.service.IAreaService;

@RequestMapping("/api")
@RestController
public class APIAreaController {
	@Autowired
	private IAreaService areaService;
	
	/**
	 * 获取所有大区
	 * @return
	 */
	@GetMapping("/areas")
	public Message getAreas() {
		Message msg = new Message();
		msg.setWhat(MessageCode.SUCCESSFUL);
		msg.setObject(areaService.selectAll());
		return msg;
	}
	
	/**
	 * 获取指定id大区信息
	 * @param areaId
	 * @return
	 */
	@GetMapping("/areas/{areaId}")
	public Message getAreaById(@PathVariable int areaId) {
		Message msg = new Message();
		Area area = areaService.selectById(areaId);
		
		if (area != null) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject(area);
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject("参数出错，请检查！");
		}
		return msg;
	}
	
}
