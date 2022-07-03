package com.itheima.domain;

import java.util.List;

public class Order {

    private Integer id;//订单ID
    private String number;//订单编号
    private User user;//订单所属用户
    private List<Goods> goodsList;//订单包含的商品类别

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" + user +
                ", goodsList=" + goodsList +
                '}';
    }
}
