package cn.howieli.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.model.Battle;
import cn.howieli.lol.service.IBattleService;

@RequestMapping("/api")
@RestController
public class APIBattleController {

	@Autowired
	private IBattleService battleService;
	
	/**
	 * 获取对战列表
	 * @param areaId
	 * @param qquin
	 * @param btList
	 * @param championId
	 * @param offset
	 * @param limit
	 * @param mvpFlag
	 * @return
	 */
	@GetMapping("/getBattleList/areaId/{areaId}/qquin/{qquin}")
	public Message getBattleList(@PathVariable int areaId, @PathVariable String qquin, 
									@RequestParam(value = "btList[]", required = false) Integer[] btList,
									@RequestParam(value = "championId", defaultValue = "0") int championId,
									@RequestParam(value = "offset", defaultValue = "0") int offset,
									@RequestParam(value = "limit", defaultValue = "8") int limit,
									@RequestParam(value = "mvpFlag", defaultValue = "-1") int mvpFlag) {
		Message msg = new Message();
		int btNum = 0;
		
		if (btList != null) {
			btNum = 1;
		}
		Map<String, Object> map = battleService.getBattleList(areaId, qquin, btNum, btList, championId, offset, limit, mvpFlag);
		if (map != null) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject(map);
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject("未知错误");
		}
		return msg;
	}
	
	/**
	 * 获取详细对战数据
	 * @param areaId
	 * @param gameId
	 * @return
	 */
	@GetMapping("/getBattleInfo/areaId/{areaId}/gameId/{gameId}")
	public Message getBattleInfo(@PathVariable int areaId, @PathVariable long gameId) {
		Message msg = new Message();
		Battle battle = battleService.getBattleInfo(areaId, gameId);
		if (battle != null) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject(battle);
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject("未知错误");
		}
		return msg;
	}
	
}
