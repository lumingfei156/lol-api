package cn.howieli.lol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {
    private int id;

    private int attack; //攻击属性值

    private int defense; //防御属性值

    private int difficulty; //难度属性值

    private int magic; //魔法属性值

    @JsonProperty("champion_id")
    private int championId;
    
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

	@Override
	public String toString() {
		return "Info [id=" + id + ", attack=" + attack + ", defense=" + defense + ", difficulty=" + difficulty
				+ ", magic=" + magic + ", championId=" + championId + "]";
	}
}