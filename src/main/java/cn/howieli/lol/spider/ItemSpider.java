package cn.howieli.lol.spider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import cn.howieli.lol.model.Item;
import cn.howieli.lol.util.GetNetDataUtil;
import cn.howieli.lol.util.ParseJsonUtil;
import cn.howieli.lol.util.URLCodeUtil;

public class ItemSpider {
	
	/**
	 * 获取游戏物品数据
	 * @return
	 */
	public static List<Item> getItemData() throws Exception {
		String data = GetNetDataUtil.GetNetData("http://lol.qq.com/biz/hero/item.js", null, false);
		String jsonData = data.substring(data.indexOf("itemjs=") + 7, data.length() - 1);
		JsonNode dataNode = ParseJsonUtil.getJsonNode(jsonData).findPath("data");
		Iterator<String> iterator = dataNode.fieldNames();
		List<Item> items = new ArrayList<Item>();
		Item item;
		String id;
		JsonNode itemNode;

		while (iterator.hasNext()) {
			id = iterator.next();
			itemNode = dataNode.findPath(id);
			
			item = new Item();
			item.setId(Integer.parseInt(id));
			item.setName(URLCodeUtil.getChinese(itemNode.findValue("name").asText()));
			item.setPlaintext(URLCodeUtil.getChinese(itemNode.findValue("plaintext").asText()));

			JsonNode intoNode = itemNode.findValue("into");
			if (intoNode == null) {
				item.setInto(null);
			} else {
				int intoLength = intoNode.size();
				String into = "";
				
				for (int i = 0; i < intoLength; i++) {
					
					if (i != intoLength - 1) {
						into += intoNode.get(i).asText() + ",";
					} else {
						into += intoNode.get(i).asText();
					}
					
				}
				item.setInto(into);
			}
			
			JsonNode fromNode = itemNode.findValue("from");
			if (fromNode == null) {
				item.setFrom(null);
			} else {
				int fromLength = fromNode.size();
				String from = "";
				
				for (int i = 0; i < fromLength; i++) {
					
					if (i != fromLength - 1) {
						from += fromNode.get(i).asText() + ",";
					} else {
						from += fromNode.get(i).asText();
					}
					
				}
				item.setFrom(from);
			}
			
			JsonNode tagsNode = itemNode.findValue("tags");
			int tagsLength = tagsNode.size();
			String tags = "";
			
			for (int i = 0; i < tagsLength; i++) {
				
				if (i != tagsLength - 1) {
					tags += tagsNode.get(i).asText() + ",";
				} else {
					tags += tagsNode.get(i).asText();
				}
				
			}
			item.setTags(tags);
			
			JsonNode goldNode = itemNode.findValue("gold");
			item.setBasePrice(goldNode.findValue("base").asInt());
			item.setTotalPrice(goldNode.findValue("total").asInt());
			item.setSellPrice(goldNode.findValue("sell").asInt());
			
			items.add(item);
		}
		return items; 
	}
	
}
