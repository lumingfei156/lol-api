package cn.howieli.lol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Admin {
    private int id;

    private String username;

    private String nickname;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String salt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", salt=" + salt + "]";
	}
}