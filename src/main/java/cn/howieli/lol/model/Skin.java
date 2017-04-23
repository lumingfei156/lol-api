package cn.howieli.lol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Skin {
    private Integer id;

    private String skinId;

    private String name;

    private Integer num;

    @JsonProperty("display_url")
    private String displayUrl;

    private String source;

    @JsonProperty("champion_id")
    private Integer championId;
    
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkinId() {
        return skinId;
    }

    public void setSkinId(String skinId) {
        this.skinId = skinId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getChampionId() {
        return championId;
    }

    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

	@Override
	public String toString() {
		return "Skin [id=" + id + ", skinId=" + skinId + ", name=" + name + ", num=" + num + ", displayUrl="
				+ displayUrl + ", source=" + source + ", championId=" + championId + "]";
	}

}