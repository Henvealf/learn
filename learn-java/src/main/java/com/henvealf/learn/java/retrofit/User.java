package com.henvealf.learn.java.retrofit;

/**
 * https://www.baeldung.com/retrofit
 * @author hongliang.yin/Henvealf
 * @date 2020/5/11
 */
public class User {

    private String login;
    private long id;
    private String url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
