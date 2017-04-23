package cn.howieli.lol.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private int id;

    private String name;

    private String from;
    
    private String[] froms;

    private String into;
    
    private String[] intos;

    private String tags;
    
    private String[] tagsArray;

    @JsonProperty("base_price")
	private int basePrice;

    @JsonProperty("total_price")
    private int totalPrice;

    @JsonProperty("sell_price")
    private int sellPrice;

    private String plaintext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
    	if (from == null) {
    		this.froms = null;
    	} else {
    		this.froms = from.split(",");
    	}
        this.from = from;
    }

    public String[] getFroms() {
		return froms;
	}

	public void setFroms(String[] froms) {
		this.froms = froms;
	}

	public String getInto() {
        return into;
    }

    public void setInto(String into) {
    	if (into == null) {
    		this.intos = null;
    	} else {
    		this.intos = into.split(",");
    	}
        this.into = into;
    }

    public String[] getIntos() {
		return intos;
	}

	public void setIntos(String[] intos) {
		this.intos = intos;
	}

	public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
    	this.tagsArray = tags.split(",");
        this.tags = tags;
    }
    
    public String[] getTagsArray() {
		return tagsArray;
	}

	public void setTagsArray(String[] tagsArray) {
		this.tagsArray = tagsArray;
	}

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", from=" + from + ", froms=" + Arrays.toString(froms) + ", into="
				+ into + ", intos=" + Arrays.toString(intos) + ", tags=" + tags + ", tagsArray="
				+ Arrays.toString(tagsArray) + ", basePrice=" + basePrice + ", totalPrice=" + totalPrice
				+ ", sellPrice=" + sellPrice + ", plaintext=" + plaintext + "]";
	}
}