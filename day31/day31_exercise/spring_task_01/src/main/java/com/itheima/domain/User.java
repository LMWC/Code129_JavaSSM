package com.itheima.domain;

public class User {

    private Integer id; //用户ID
    private String userName; //用户名称

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
