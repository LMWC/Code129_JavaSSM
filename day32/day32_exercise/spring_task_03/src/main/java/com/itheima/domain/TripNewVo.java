package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class TripNewVo implements Serializable{
    private Long id; //主键ID
    private String username; //用户名称
    private Integer gender; //0:女 1:男
    private String idcard; //用户身份证
    private String fromAddress; //出发地
    private String toAddress;//到达地
    private Date startTime;//出发时间

    @Override
    public String toString() {
        return "TripNewVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", idcard='" + idcard + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", startTime=" + startTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
