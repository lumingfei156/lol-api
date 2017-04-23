package cn.howieli.lol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gamer {
	private String qquin;	//玩家唯一标识
	
	private String name;	//玩家昵称
	
	@JsonProperty("champion_id")
	private int championId;	//所使用英雄
	
	private int level;		//对局内等级
	
	private int exp;	//经验
	
	private int win;	//1胜利，2失败,129逃跑胜利,130逃跑失败
	
	private int[] items;	//物品
	
	@JsonProperty("gold_earned")
	private int goldEarned;	//赚得金币
	
	@JsonProperty("gold_spent")
	private int goldSpent;		//花费金币
	
	@JsonProperty("champions_killed")
	private int championsKilled;	//杀人数
	
	@JsonProperty("num_deaths")
	private int numDeaths; 	//死亡数
	
	private int assists;		//助攻数
	
	@JsonProperty("minions_killed")
	private int minionsKilled;		//补兵数
	
	@JsonProperty("turrets_killed")
	private int turretsKilled;		//推塔数
	
	@JsonProperty("total_damage_dealt")
	private int totalDamageDealt;		//输出伤害
	
	@JsonProperty("total_damage_takens")
	private int totalDamageTaken;		//承受伤害
	
	@JsonProperty("total_damage_dealt_to_champions")
	private int totalDamageDealtToChampions;	//对英雄造成的伤害
	
	@JsonProperty("physical_damage_dealt_to_champions")
	private int physicalDamageDealtToChampions;	//对英雄造成的物理伤害
	
	@JsonProperty("magic_damage_dealt_to_champions")
	private int magicDamageDealtToChampions;	//对英雄造成的魔法伤害
	
	@JsonProperty("largest_killing_spree")
	private int largestKillingSpree;	//最大连杀
	
	@JsonProperty("largest_multi_kill")
	private int largestMultiKill;		//最大多杀
	
	@JsonProperty("barracks_killed")
	private int barracksKilled;	//兵营，其实我也不太懂这个数据是什么
	
	@JsonProperty("total_health")
	private int totalHealth;	//总治疗
	
	@JsonProperty("summon_spell1_id")
	private int summonSpell1Id;	//召唤师技能1，ID
	
	@JsonProperty("summon_spell2_id")
	private int summonSpell2Id;	//召唤师技能2，ID
	
	@JsonProperty("game_score")
	private int gameScore;		//TGP显示的评分，是该值除以100
	
	@JsonProperty("ward_killed")
	private int wardKilled;	//鬼知道这是啥
	
	@JsonProperty("ward_placed")
	private int wardPlaced;	//鬼也不知道的这是啥
	
	@JsonProperty("neutral_minions_killed")
	private int neutralMinionsKilled;		//字面意思是被中立区的小兵杀害，估计是小兵野怪这些吧，TGP上面也没有显示
	
	@JsonProperty("super_monster_killed")
	private int superMonsterKilled;	//字面意思是被超级怪物杀害，应该是大龙和小龙吧，TGP也没显示，或许是我没找到

	@JsonProperty("skin_id")
	private int skinId;	//皮肤ID，由当前英雄id+每个英雄相对应的皮肤id
	
	@JsonProperty("ext_flag")
	private int extFlag;	//显示是什么局，甩锅局等等等等

	@JsonProperty("triple_kills")
	private int tripleKills;	//三杀次数
	
	@JsonProperty("quadra_kills")
	private int quadraKills;	//四杀次数
	
	@JsonProperty("penta_kills")
	private int pentaKills;	//五杀次数

	public String getQquin() {
		return qquin;
	}

	public void setQquin(String qquin) {
		this.qquin = qquin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int[] getItems() {
		return items;
	}

	public void setItems(int[] items) {
		this.items = items;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public int getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(int goldSpent) {
		this.goldSpent = goldSpent;
	}

	public int getChampionsKilled() {
		return championsKilled;
	}

	public void setChampionsKilled(int championsKilled) {
		this.championsKilled = championsKilled;
	}

	public int getNumDeaths() {
		return numDeaths;
	}

	public void setNumDeaths(int numDeaths) {
		this.numDeaths = numDeaths;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getMinionsKilled() {
		return minionsKilled;
	}

	public void setMinionsKilled(int minionsKilled) {
		this.minionsKilled = minionsKilled;
	}

	public int getTurretsKilled() {
		return turretsKilled;
	}

	public void setTurretsKilled(int turretsKilled) {
		this.turretsKilled = turretsKilled;
	}

	public int getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(int totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public int getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(int totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public int getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public int getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public int getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public int getLargestKillingSpree() {
		return largestKillingSpree;
	}

	public void setLargestKillingSpree(int largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}

	public int getLargestMultiKill() {
		return largestMultiKill;
	}

	public void setLargestMultiKill(int largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}

	public int getBarracksKilled() {
		return barracksKilled;
	}

	public void setBarracksKilled(int barracksKilled) {
		this.barracksKilled = barracksKilled;
	}

	public int getTotalHealth() {
		return totalHealth;
	}

	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}

	public int getSummonSpell1Id() {
		return summonSpell1Id;
	}

	public void setSummonSpell1Id(int summonSpell1Id) {
		this.summonSpell1Id = summonSpell1Id;
	}

	public int getSummonSpell2Id() {
		return summonSpell2Id;
	}

	public void setSummonSpell2Id(int summonSpell2Id) {
		this.summonSpell2Id = summonSpell2Id;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	public int getWardKilled() {
		return wardKilled;
	}

	public void setWardKilled(int wardKilled) {
		this.wardKilled = wardKilled;
	}

	public int getWardPlaced() {
		return wardPlaced;
	}

	public void setWardPlaced(int wardPlaced) {
		this.wardPlaced = wardPlaced;
	}

	public int getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(int neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public int getSuperMonsterKilled() {
		return superMonsterKilled;
	}

	public void setSuperMonsterKilled(int superMonsterKilled) {
		this.superMonsterKilled = superMonsterKilled;
	}

	public int getSkinId() {
		return skinId;
	}

	public void setSkinId(int skinId) {
		this.skinId = skinId;
	}

	public int getExtFlag() {
		return extFlag;
	}

	public void setExtFlag(int extFlag) {
		this.extFlag = extFlag;
	}

	public int getTripleKills() {
		return tripleKills;
	}

	public void setTripleKills(int tripleKills) {
		this.tripleKills = tripleKills;
	}

	public int getQuadraKills() {
		return quadraKills;
	}

	public void setQuadraKills(int quadraKills) {
		this.quadraKills = quadraKills;
	}

	public int getPentaKills() {
		return pentaKills;
	}

	public void setPentaKills(int pentaKills) {
		this.pentaKills = pentaKills;
	}
}
