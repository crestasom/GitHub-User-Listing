package com.example.githubuserdetails.model;

import com.google.gson.annotations.SerializedName;

public class UserDetails {
    @SerializedName("id")
    private int id;
    @SerializedName("login")
    private String login;
    @SerializedName("avatar_id")
    private String avatarId;
    @SerializedName("url")
    private String url;
    @SerializedName("html_url")
    private String htmlUrl;

    public UserDetails(int id, String login, String avatarId, String url, String htmlUrl) {
        this.id = id;
        this.login = login;
        this.avatarId = avatarId;
        this.url = url;
        this.htmlUrl = htmlUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", avatarId='" + avatarId + '\'' +
                ", url='" + url + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}';
    }
}
