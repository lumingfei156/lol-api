package cn.howieli.lol.spider;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import cn.howieli.lol.model.Player;
import cn.howieli.lol.util.GetNetDataUtil;
import cn.howieli.lol.util.ParseJsonUtil;
import cn.howieli.lol.util.URLCodeUtil;

public class PlayerSpider {
	
	/**
	 * 通过游戏昵称检索出该名称在各大区信息
	 * @param playerName
	 * @return
	 */
	public static List<Player> searchPlayerList(String playerName) throws Exception {
		String jsonData = GetNetDataUtil.GetNetData("http://api.pallas.tgp.qq.com/core/search_player", "key=" + URLCodeUtil.getUTF8(playerName), true);
		
		/**
		 * 有的时候Cookie会失效
		 */
		while(jsonData.contains("2002")) {
			jsonData = GetNetDataUtil.GetNetData("http://api.pallas.tgp.qq.com/core/search_player", "key=" + URLCodeUtil.getUTF8(playerName), true);
		}
		
		List<Player> players = new ArrayList<Player>();
		Player player = null;
		JsonNode rootNode = ParseJsonUtil.getJsonNode(jsonData);
		JsonNode dataNode = rootNode.path("data");
		for (int i = 0; i < dataNode.size(); i++) {
			player = new Player();
			player.setAreaId(dataNode.findValues("area_id").get(i).asInt());
			player.setQquin(dataNode.findValues("qquin").get(i).asText());
			player.setIcon(dataNode.findValues("icon_id").get(i).asInt());
			player.setName(dataNode.findValues("name").get(i).asText());
			player.setLevel(dataNode.findValues("level").get(i).asInt());
			player.setTier(dataNode.findValues("tier").get(i).asInt());
			player.setQueue(dataNode.findValues("queue").get(i).asInt());
			player.setWinPoint(dataNode.findValues("win_point").get(i).asInt());
			players.add(player);
		}
		return players;
	}
	
	/**
	 * 封装各大区段位排行榜--玩家
	 * @param areaId 大区ID
	 * @param pageNum 第几页
	 * @return
	 */
	public static List<Player> playerTierRanking(int areaId, int pageNum) throws Exception {
		String jsonData = GetNetDataUtil.GetNetData("http://api.pallas.tgp.qq.com/core/get_score_rank", "area_id=" + areaId + "&pnum=" + pageNum, true);
		
		while(jsonData.contains("2002")) {
			jsonData = GetNetDataUtil.GetNetData("http://api.pallas.tgp.qq.com/core/get_score_rank", "area_id=" + areaId + "&pnum=" + pageNum, true);
		}
		
		List<Player> players = new ArrayList<Player>();
		Player player = null;
		int[] champions = null;
		JsonNode rootNode = ParseJsonUtil.getJsonNode(jsonData);
		JsonNode rankingNode = rootNode.path("data").path("rank_list");
		
		for (int i = 0; i < rankingNode.size(); i++) {
			player = new Player();
			player.setAreaId(areaId);
			player.setRanking(rankingNode.findValues("ranking").get(i).asInt());
			player.setQquin(rankingNode.findValues("qquin").get(i).asText());
			player.setName(rankingNode.findValues("name").get(i).asText());
			player.setIcon(rankingNode.findValues("icon_id").get(i).asInt());
			player.setTier(rankingNode.findValues("tier").get(i).asInt());
			player.setQueue(rankingNode.findValues("queue").get(i).asInt());
			player.setWinPoint(rankingNode.findValues("win_point").get(i).asInt());
			JsonNode champNode = rankingNode.get(i).path("champions");
			champions = new int[champNode.size()];
			for (int j = 0; j < champions.length; j++) {
				champions[j] = champNode.get(j).asInt();
			}
			player.setChampions(champions);
			players.add(player);
		}
		return players;
	}
}
