package cn.howieli.lol.spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import cn.howieli.lol.model.Champion;
import cn.howieli.lol.model.Info;
import cn.howieli.lol.model.Skin;
import cn.howieli.lol.model.Spell;
import cn.howieli.lol.util.GetNetDataUtil;
import cn.howieli.lol.util.ParseJsonUtil;
import cn.howieli.lol.util.URLCodeUtil;

public class ChampionSpider {
	
	/**
	 * 获取英雄数据
	 * @return
	 */
	public static List<Champion> getChampionData() throws Exception {
		String data = GetNetDataUtil.GetNetData("http://lol.qq.com/biz/hero/champion.js", null, false);
		String jsonData = data.substring(data.indexOf("\"data\":") + 7, data.indexOf(",\"version\""));
		JsonNode rootNode = ParseJsonUtil.getJsonNode(jsonData);
		JsonNode dataNode;
		Iterator<String> iterator = rootNode.fieldNames();
		List<Champion> champions = new ArrayList<Champion>();
		Champion champion;
		
		while (iterator.hasNext()) {
			dataNode = rootNode.findValue(iterator.next());
			
			champion = new Champion();
			champion.setId(dataNode.findValue("key").asInt());
			champion.setEname(dataNode.findValue("id").asText());
			champion.setCname(URLCodeUtil.getChinese(dataNode.findValue("title").asText())); //这两个没写错，我之前定义的name就应该是他的中文名
			champion.setTitle(URLCodeUtil.getChinese(dataNode.findValue("name").asText())); //而title应该是这个英雄的名号
			
			int tagsLength = dataNode.findValue("tags").size();
			String tags = "";
			for (int i = 0; i < tagsLength; i++) {
				
				if (i != tagsLength - 1) {
					tags += dataNode.findValue("tags").get(i).asText() + ",";
				} else {
					tags += dataNode.findValue("tags").get(i).asText();
				}
				
			}
			champion.setTags(tags);
			champion.setFree(false);
			
			champions.add(champion);
		}
		
		champions = getChampionPrice(champions);
		champions = getFreeChampion(champions);
		
		/**
		 * 暂时放到这里排序
		 */
		Collections.sort(champions, new Comparator<Champion>() {

			@Override
			public int compare(Champion o1, Champion o2) {
				if (o1.getId() > o2.getId()) {
					return 1;
				}
				return -1;
			}
			
		});
		
		return champions;
	}
	
	/**
	 * 获取英雄价格 rmb:点券 gold:金币
	 * @param champions
	 * @return
	 */
	public static List<Champion> getChampionPrice(List<Champion> champions) throws Exception {
		String data = GetNetDataUtil.GetNetData("http://cdn.tgp.qq.com/lol/conf/LOLChampPrice.js", null, false);
		String jsonData = data.substring(data.indexOf("ChampPrice=") + 11, data.length() - 1);
		JsonNode rootNode = ParseJsonUtil.getJsonNode(jsonData);
		Iterator<String> iterator = rootNode.fieldNames();
		JsonNode dataNode;
		
		/**
		 * 这一块有待优化，现在是一个一个比对，感觉太傻了
		 * 感觉到了自己在算法方面的缺失。。。
		 */
		while (iterator.hasNext()) {
			dataNode = rootNode.findValue(iterator.next());
			int championId = dataNode.findValue("champion_id").asInt();
			for (int i = 0; i < champions.size(); i++) {
				Champion champion = champions.get(i);
				if (championId == champion.getId()) {
					champions.remove(i);
					champion.setRmb(dataNode.findValue("rmb").asInt());
					champion.setGold(dataNode.findValue("gold").asInt());
					champions.add(i, champion);
					break;
				}
			}
		}
		
		return champions;
	}
	
	/**
	 * 设置周免英雄
	 * @param champions
	 * @return
	 */
	public static List<Champion> getFreeChampion(List<Champion> champions) throws Exception {
		String data = GetNetDataUtil.GetNetData("http://lol.qq.com/biz/hero/free.js", null, false);
		String jsonData = data.substring(data.indexOf("\"keys\":") + 7, data.indexOf(",\"data\""));
		JsonNode rootNode = ParseJsonUtil.getJsonNode(jsonData);
		Iterator<String> iterator = rootNode.fieldNames();

		/**
		 * 同上，有待优化
		 */
		while (iterator.hasNext()) {
			int championId = Integer.parseInt(iterator.next());
			for (int i = 0; i < champions.size(); i++) {
				Champion champion = champions.get(i);
				if (championId == champion.getId()) {
					champions.remove(i);
					champion.setFree(true);
					champions.add(i, champion);
					break;
				}
			}
		}
		
		return champions;
	}
	
	/**
	 * 获取某个英雄的详细信息
	 * @return
	 */
	public static Map<String, Object> getChampionDetailsInfo(List<Champion> champions) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Info> infos = new ArrayList<Info>();
		List<Skin> skins = new ArrayList<Skin>();
		List<Spell> spells = new ArrayList<>();
		
		for (Champion champion : champions) {
			String data = GetNetDataUtil.GetNetData("http://cdn.tgp.qq.com/lol/conf/heros/" + champion.getId() + ".js", null, false);
			String jsonData;
			
			if (data.contains("data:")) {
				jsonData = data.substring(data.indexOf("data:") + 5, data.indexOf(",updated"));
			} else {
				if (data.contains(",        \"updated\"")) {
					jsonData = data.substring(data.indexOf("\"data\": ") + 8, data.indexOf(",        \"updated\""));
				} else {
					jsonData = data.substring(data.indexOf("\"data\": ") + 8, data.indexOf(", \"updated\""));
				}
			}
			
			JsonNode rootNode = ParseJsonUtil.getJsonNode(jsonData);
			
			infos.add(getChampionInfo(rootNode, champion)); //英雄属性
			skins.addAll(getChampionSkins(rootNode, champion)); //英雄皮肤
			spells.addAll(getChampionSpells(rootNode, champion)); //英雄技能

		}
		
		map.put("info", infos);
		map.put("skin", skins);
		map.put("spell", spells);
		
		return map;
	}
	
	/**
	 * 获取英雄基本属性
	 * @param rootNode
	 * @param champion
	 * @return
	 */
	private static Info getChampionInfo(JsonNode rootNode, Champion champion) {
		Info info = new Info();
		JsonNode infoNode = rootNode.findValue("info");
		info.setChampionId(champion.getId());
		info.setAttack(infoNode.findValue("attack").asInt());
		info.setDefense(infoNode.findValue("defense").asInt());
		info.setDifficulty(infoNode.findValue("difficulty").asInt());
		info.setMagic(infoNode.findValue("magic").asInt());
		return info;
	}
	
	/**
	 * 获取英雄皮肤
	 * @param rootNode
	 * @param champion
	 * @return
	 */
	private static List<Skin> getChampionSkins(JsonNode rootNode, Champion champion) {
		List<Skin> skins = new ArrayList<Skin>();
		Skin skin;
		JsonNode skinNode = rootNode.path("skins");
		for (int i = 0; i < skinNode.size(); i++) {
			skin = new Skin();
			skin.setChampionId(champion.getId());
			skin.setSkinId(skinNode.get(i).findValue("id").asText());
			skin.setNum(skinNode.get(i).findValue("num").asInt());
			skin.setName(skinNode.get(i).findValue("name").asText());
			
			if (skinNode.get(i).findValue("displayUrl") != null) {
				skin.setDisplayUrl(skinNode.get(i).findValue("displayUrl").asText());
			} else {
				skin.setDisplayUrl(null);
			}
			
			skin.setSource(skinNode.get(i).findValue("source").asText());
			skins.add(skin);
		}
		return skins;
	}
	
	/**
	 * 获取英雄技能
	 * @param rootNode
	 * @param champion
	 * @return
	 */
	private static List<Spell> getChampionSpells(JsonNode rootNode, Champion champion) {
		List<Spell> spells = new ArrayList<Spell>();
		Spell spell;
		
		/**
		 * 英雄技能-被动
		 * 被动技能图标URL前缀:http://cdn.tgp.qq.com/lol/images/resources/passive/
		 */
		JsonNode passiveNode = rootNode.path("passive"); //被动技能节点
		spell = new Spell();
		spell.setChampionId(champion.getId());
		spell.setSpellId("passive"); //标识为被动
		spell.setSpellKey("Passive");
		spell.setName(passiveNode.findValue("name").asText());
		spell.setDescription(passiveNode.findValue("description").asText());
		spell.setImage(passiveNode.path("image").findValue("full").asText());
		spells.add(spell);
		
		/**
		 * 英雄技能-主动
		 * 主动技能图标URL前缀:http://cdn.tgp.qq.com/lol/images/resources/skill/
		 */
		JsonNode spellsNode = rootNode.path("spells"); //主动技能节点
		for (int i = 0; i < spellsNode.size(); i++) {
			JsonNode spellNode = spellsNode.get(i);
			spell = new Spell();
			spell.setChampionId(champion.getId());
			spell.setSpellId(spellNode.findValue("id").asText());
			
			String spellName = spellNode.findValue("name").asText();
			if (spellName.contains("Q")) {
				spell.setSpellKey("Q");
			} else if (spellName.contains("W")) {
				spell.setSpellKey("W");
			} else if (spellName.contains("E")) {
				spell.setSpellKey("E");
			} else if (spellName.contains("R")) {
				spell.setSpellKey("R");
			}

			spell.setName(spellName);
			spell.setDescription(spellNode.findValue("tooltip").asText());
			spell.setImage(spellNode.findPath("image").findValue("full").asText());
			
			spells.add(spell);
		}
		return spells;
	}
}
