package cn.howieli.lol.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
	private int ranking;
	
	@JsonProperty("area_id")
	private int areaId;
	
	private String qquin;
	
	private int icon;
	
	private String name;
	
	private int level;
	
	private int tier;
	
	private int queue;
	
	@JsonProperty("win_point")
	private int winPoint;
	
	private int[] champions;
	
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int[] getChampions() {
		return champions;
	}
	public void setChampions(int[] champions) {
		this.champions = champions;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getQquin() {
		return qquin;
	}
	public void setQquin(String qquin) {
		this.qquin = qquin;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	public int getQueue() {
		return queue;
	}
	public void setQueue(int queue) {
		this.queue = queue;
	}
	public int getWinPoint() {
		return winPoint;
	}
	public void setWinPoint(int winPoint) {
		this.winPoint = winPoint;
	}
	@Override
	public String toString() {
		return "Player [ranking=" + ranking + ", areaId=" + areaId + ", qquin=" + qquin + ", icon=" + icon + ", name="
				+ name + ", level=" + level + ", tier=" + tier + ", queue=" + queue + ", winPoint=" + winPoint
				+ ", champions=" + Arrays.toString(champions) + "]";
	}
}
