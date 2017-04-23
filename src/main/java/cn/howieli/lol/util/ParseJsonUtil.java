package cn.howieli.lol.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseJsonUtil {
		
	public static JsonNode getJsonNode(String jsonData) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			rootNode = mapper.readValue(jsonData, JsonNode.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rootNode;
	}
}
