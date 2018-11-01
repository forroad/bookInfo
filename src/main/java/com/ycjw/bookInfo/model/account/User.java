package com.ycjw.bookInfo.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    //id
    private String id;
    //账号
    private String account;
    //名字
    private String name;
    //密码
    @JsonIgnore
    private String password;
    //盐
    @JsonIgnore
    private String salt;
    //角色
    private Role role;

    public enum Role{
        normal,admin
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

