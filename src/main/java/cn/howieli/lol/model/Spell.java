package cn.howieli.lol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Spell {
    private int id;

    private String spellId;

    private String spellKey;

    private String name;

    private String description;

    private String image;

    @JsonProperty("champion_id")
    private int championId;
    
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpellId() {
        return spellId;
    }

    public void setSpellId(String spellId) {
        this.spellId = spellId;
    }

    public String getSpellKey() {
        return spellKey;
    }

    public void setSpellKey(String spellKey) {
        this.spellKey = spellKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

	@Override
	public String toString() {
		return "Spell [id=" + id + ", spellId=" + spellId + ", spellKey=" + spellKey + ", name=" + name
				+ ", description=" + description + ", image=" + image + ", championId=" + championId + "]";
	}
}