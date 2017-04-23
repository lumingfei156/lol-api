package cn.howieli.lol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.howieli.lol.controller.msg.Message;
import cn.howieli.lol.controller.msg.MessageCode;
import cn.howieli.lol.model.Player;
import cn.howieli.lol.service.IPlayerService;

@RequestMapping("/api")
@RestController
public class APIPlayerController {
	@Autowired
	private IPlayerService playerService;
	
	/**
	 * 通过玩家昵称搜索
	 * @param playerName
	 * @return
	 */
	@GetMapping("/searchPlayers/{playerName}")
	public Message searchPlayers(@PathVariable String playerName) {
		Message msg = new Message();
		List<Player> players = playerService.searchPlayerList(playerName);
		if (players != null) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject(players);
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject(MessageCode.FAILLY);
		}
		return msg;
	}
	
	/**
	 * 排位排行榜
	 * @param areaId 大区ID
	 * @param pageNum 第几页
	 * @return
	 */
	@GetMapping("/playerRanking/areaId/{areaId}")
	public Message playerTierRanking(@PathVariable int areaId, @RequestParam("pageNum") int pageNum) {
		Message msg = new Message();
		List<Player> players = playerService.playerTierRanking(areaId, pageNum);
		if (players != null) {
			msg.setWhat(MessageCode.SUCCESSFUL);
			msg.setObject(players);
		} else {
			msg.setWhat(MessageCode.FAIL);
			msg.setObject(MessageCode.FAILLY);
		}
		return msg;
	}
	
}
