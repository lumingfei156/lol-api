package cn.howieli.lol.model;

import java.util.Arrays;
import java.util.List;

public class Champion {
    private int id;

    private String ename;

    private String title;

    private String cname;
    
    private int rmb;
    
    private int gold;

    private String tags;

    private String[] tagsArray;
    
    private Boolean free;
    
    private Info info;
    
    private List<Skin> skins;
    
    private List<Spell> spells;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

	public int getRmb() {
		return rmb;
	}

	public void setRmb(int rmb) {
		this.rmb = rmb;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		setTagsArray(tags.split(","));
		this.tags = tags;
	}
	
	public String[] getTagsArray() {
		return tagsArray;
	}

	public void setTagsArray(String[] tagsArray) {
		this.tagsArray = tagsArray;
	}

	public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<Skin> getSkins() {
		return skins;
	}

	public void setSkins(List<Skin> skins) {
		this.skins = skins;
	}

	public List<Spell> getSpells() {
		return spells;
	}

	public void setSpells(List<Spell> spells) {
		this.spells = spells;
	}

	@Override
	public String toString() {
		return "Champion [id=" + id + ", ename=" + ename + ", title=" + title + ", cname=" + cname + ", rmb=" + rmb
				+ ", gold=" + gold + ", tags=" + tags + ", tagsArray=" + Arrays.toString(tagsArray) + ", free=" + free
				+ ", info=" + info + ", skins=" + skins + ", spells=" + spells + "]";
	}
}