package cn.howieli.lol.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Battle {
	@JsonProperty("game_id")
	private long gameId;
	
	@JsonProperty("start_time")
	private String startTime;
	
	@JsonProperty("stop_time")
	private String stopTime;
	
	private long duration;
	
	@JsonProperty("battle_map")
	private int battleMap;
	
	@JsonProperty("game_type")
	private int gameType;
	
	@JsonProperty("game_mode")
	private int gameMode;
	
	@JsonProperty("champion_id")
	private int championId;
	
	private int win;
	
	private int flag;
	
	@JsonProperty("ext_flag")
	private int extFlag;
	
	@JsonProperty("gamer_num")
	private int gamerNum;
	
	private List<Gamer> gamers;

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getBattleMap() {
		return battleMap;
	}

	public void setBattleMap(int battleMap) {
		this.battleMap = battleMap;
	}

	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public int getGameMode() {
		return gameMode;
	}

	public void setGameMode(int gameMode) {
		this.gameMode = gameMode;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getExtFlag() {
		return extFlag;
	}

	public void setExtFlag(int extFlag) {
		this.extFlag = extFlag;
	}

	public int getGamerNum() {
		return gamerNum;
	}

	public void setGamerNum(int gamerNum) {
		this.gamerNum = gamerNum;
	}

	public List<Gamer> getGamers() {
		return gamers;
	}

	public void setGamers(List<Gamer> gamers) {
		this.gamers = gamers;
	}

	@Override
	public String toString() {
		return "Battle [gameId=" + gameId + ", startTime=" + startTime + ", stopTime=" + stopTime + ", duration="
				+ duration + ", battleMap=" + battleMap + ", gameType=" + gameType + ", gameMode=" + gameMode
				+ ", championId=" + championId + ", win=" + win + ", flag=" + flag + ", extFlag=" + extFlag
				+ ", gamerNum=" + gamerNum + ", gamers=" + gamers + "]";
	}
}
