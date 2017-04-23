package cn.howieli.lol.model;

public class SummonerSpell {
    private String id;

    private String name;

    private String image;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "SummonerSpell [id=" + id + ", name=" + name + ", image=" + image + ", description=" + description + "]";
	}
}