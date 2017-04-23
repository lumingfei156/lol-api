package cn.howieli.lol.spider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import cn.howieli.lol.model.SummonerSpell;
import cn.howieli.lol.util.GetNetDataUtil;
import cn.howieli.lol.util.ParseJsonUtil;
import cn.howieli.lol.util.URLCodeUtil;

public class SummonerSpellSpider {
	
	/**
	 * 获取召唤师技能数据
	 * @return
	 */
	public static List<SummonerSpell> getSummonerSpellData() throws Exception {
		String data = GetNetDataUtil.GetNetData("http://lol.qq.com/biz/hero/summoner.js", null, false);
		String jsonData = data.substring(data.indexOf("js=") + 3, data.length() - 1);
		JsonNode dataNode = ParseJsonUtil.getJsonNode(jsonData).path("data");
		Iterator<String> iterator = dataNode.fieldNames();
		List<SummonerSpell> summonerSpells = new ArrayList<SummonerSpell>();
		SummonerSpell summonerSpell;
		String id;
		JsonNode spellNode;
		
		while (iterator.hasNext()) {
			id = iterator.next();
			spellNode = dataNode.findPath(id);
			
			summonerSpell = new SummonerSpell();
			summonerSpell.setId(id);
			summonerSpell.setName(URLCodeUtil.getChinese(spellNode.findValue("name").asText()));
			summonerSpell.setDescription(URLCodeUtil.getChinese(spellNode.findValue("description").asText()));
			summonerSpell.setImage(spellNode.findValue("image").findValue("full").asText());
			
			summonerSpells.add(summonerSpell);
		}
		return summonerSpells;
	}
	
}
