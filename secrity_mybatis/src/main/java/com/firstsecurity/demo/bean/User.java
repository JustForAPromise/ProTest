package com.firstsecurity.demo.bean;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String pwd;

    public User(){}
    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.pwd = user.pwd;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
