package cn.howieli.lol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Count {
	@JsonIgnore
    private int id;

	@JsonProperty("api_nums")
    private int apiNums;

    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApiNums() {
        return apiNums;
    }

    public void setApiNums(int apiNums) {
        this.apiNums = apiNums;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}