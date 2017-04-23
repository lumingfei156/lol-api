package cn.howieli.lol.spider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import cn.howieli.lol.model.Battle;
import cn.howieli.lol.model.Gamer;
import cn.howieli.lol.util.GetNetDataUtil;
import cn.howieli.lol.util.ParseJsonUtil;

public class BattleSpider {
	
	/**
	 * 获取战绩列表
	 * @param areaId
	 * @param qquin
	 * @param btNum
	 * @param btList
	 * @param championId
	 * @param offset
	 * @param limit
	 * @param mvpFlag
	 * @return
	 */
	public static Map<String, Object> getBattleList(int areaId, String qquin, int btNum, Integer[] btList, int championId,
			int offset, int limit, int mvpFlag) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String p = "[[3,{\"area_id\":\"" + areaId + "\",\"qquin\":\"" + qquin + "\",\"bt_num\":\"" + btNum
						+ "\",\"bt_list\":" + array2String(btList) + ",\"champion_id\":" + championId + ",\"offset\":" + offset
						+ ",\"limit\":" + limit + ",\"mvp_flag\":" + mvpFlag + "}]]";
		String data = GetNetDataUtil.GetNetData("http://api.pallas.tgp.qq.com/core/get_player_battle_list", "p=" + p, true);
		JsonNode dataNode = ParseJsonUtil.getJsonNode(data).path("data");
		JsonNode battleListNode = dataNode.findValue("battle_list");
		
		map.put("total_num", dataNode.findValue("total_num").asText());
		map.put("list_num", dataNode.findValue("list_num").asText());
		map.put("total_win_num", dataNode.findValue("total_win_num").asText());
		
		List<Battle> battles = new ArrayList<Battle>();
		JsonNode battleNode;
		Battle battle;
		for (int i = 0; i < battleListNode.size(); i++) {
			battleNode = battleListNode.get(i);
			
			battle = new Battle();
			battle.setGameId(battleNode.findValue("game_id").asLong());
			battle.setStartTime(battleNode.findValue("battle_time").asText());
			battle.setBattleMap(battleNode.findValue("battle_map").asInt());
			battle.setGameType(battleNode.findValue("game_type").asInt());
			battle.setGameMode(battleNode.findValue("game_mode").asInt());
			battle.setChampionId(battleNode.findValue("champion_id").asInt());
			battle.setWin(battleNode.findValue("win").asInt());
			battle.setFlag(battleNode.findValue("flag").asInt());
			battle.setExtFlag(battleNode.findValue("ext_flag").asInt());
			
			battles.add(battle);
		}
		map.put("battle_list", battles);
		return map;
	}
	
	/**
	 * 获取对局详细信息
	 * @param areaId
	 * @param gameId
	 * @return
	 */
	public static Battle getBattleInfo(int areaId, long gameId) throws Exception {
		String p = "{\"area_id\":" + areaId + ",\"game_id\":" + gameId + "}";
		String data = GetNetDataUtil.GetNetData("http://api.pallas.tgp.qq.com/core/get_battle_info", "p=" + p, true);
		JsonNode battleNode = ParseJsonUtil.getJsonNode(data).path("data").path("battle");
		JsonNode gamersNode = battleNode.path("gamer_records");
		JsonNode gamerNode;
		Battle battle = new Battle();
		List<Gamer> gamers = new ArrayList<Gamer>();
		Gamer gamer;
		int[] items;
		
		battle.setGameId(battleNode.findValue("game_id").asLong());
		battle.setStartTime(battleNode.findValue("start_time").asText());
		battle.setStopTime(battleNode.findValue("stop_time").asText());
		battle.setDuration(battleNode.findValue("duration").asLong());
		battle.setBattleMap(battleNode.findValue("battle_map").asInt());
		battle.setGamerNum(battleNode.findValue("gamer_num").asInt());
		battle.setGameType(battleNode.findValue("game_type").asInt());
		battle.setGameMode(battleNode.findValue("game_mode").asInt());
		
		for (int i = 0; i < gamersNode.size(); i++) {
			gamerNode = gamersNode.get(i);
			
			gamer = new Gamer();
			gamer.setQquin(gamerNode.findValue("qquin").asText());
			gamer.setName(gamerNode.findValue("name").asText());
			gamer.setChampionId(gamerNode.findValue("champion_id").asInt());
			gamer.setLevel(gamerNode.findValue("level").asInt());
			gamer.setExp(gamerNode.findValue("exp").asInt());
			gamer.setWin(gamerNode.findValue("win").asInt());
			gamer.setGoldEarned(gamerNode.findValue("gold_earned").asInt());
			gamer.setGoldSpent(gamerNode.findValue("gold_spent").asInt());
			gamer.setChampionsKilled(gamerNode.findValue("champions_killed").asInt());
			gamer.setNumDeaths(gamerNode.findValue("num_deaths").asInt());
			gamer.setAssists(gamerNode.findValue("assists").asInt());
			gamer.setMinionsKilled(gamerNode.findValue("minions_killed").asInt());
			gamer.setTurretsKilled(gamerNode.findValue("turrets_killed").asInt());
			gamer.setTotalDamageDealt(gamerNode.findValue("total_damage_dealt").asInt());
			gamer.setTotalDamageTaken(gamerNode.findValue("total_damage_taken").asInt());
			gamer.setTotalDamageDealtToChampions(gamerNode.findValue("total_damage_dealt_to_champions").asInt());
			gamer.setPhysicalDamageDealtToChampions(gamerNode.findValue("physical_damage_dealt_to_champions").asInt());
			gamer.setMagicDamageDealtToChampions(gamerNode.findValue("magic_damage_dealt_to_champions").asInt());
			gamer.setLargestKillingSpree(gamerNode.findValue("largest_killing_spree").asInt());
			gamer.setLargestMultiKill(gamerNode.findValue("largest_multi_kill").asInt());
			gamer.setBarracksKilled(gamerNode.findValue("barracks_killed").asInt());
			gamer.setTotalHealth(gamerNode.findValue("total_health").asInt());
			gamer.setSummonSpell1Id(gamerNode.findValue("summon_spell1_id").asInt());
			gamer.setSummonSpell2Id(gamerNode.findValue("summon_spell2_id").asInt());
			gamer.setGameScore(gamerNode.findValue("game_score").asInt());
			gamer.setWardKilled(gamerNode.findValue("ward_killed").asInt());
			gamer.setWardPlaced(gamerNode.findValue("ward_placed").asInt());
			gamer.setNeutralMinionsKilled(gamerNode.findValue("neutral_minions_killed").asInt());
			gamer.setSuperMonsterKilled(gamerNode.findValue("super_monster_killed").asInt());
			gamer.setSkinId(gamerNode.findValue("skin_id").asInt());
			gamer.setExtFlag(gamerNode.findValue("ext_flag").asInt());
			gamer.setTripleKills(gamerNode.findValue("triple_kills").asInt());
			gamer.setQuadraKills(gamerNode.findValue("quadra_kills").asInt());
			gamer.setPentaKills(gamerNode.findValue("penta_kills").asInt());
			
			items = new int[7];
			for (int j = 0; j < items.length; j++) {
				items[j] = gamerNode.findValue("item" + j).asInt();
			}
			gamer.setItems(items);
			
			gamers.add(gamer);
		}
		battle.setGamers(gamers);
		
		return battle;
	}
	
	
	/**
	 * 数组转字符串
	 * @param array
	 * @return
	 */
	public static String array2String(Integer[] array) {
		String str = "";
		if (array == null || array.length == 0) {
			str = "[]";
		} else {
			for (int i = 0; i < array.length; i++) {
				if (i == 0) {
					str += "[" + array[i];
				} else if (i == array.length - 1) {
					str += "," + array[i] + "]";
				} else {
					str += "," + array[i];
				}
			}
		}
		return str;
	}
	
}
