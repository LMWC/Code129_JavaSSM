package com.itheima.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private Double costprice;
    private Integer surplusnum;
    private Integer allnum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //返回JSON数据设置日期的格式
    private Date created;


    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", costprice=" + costprice +
                ", surplusnum=" + surplusnum +
                ", allnum=" + allnum +
                ", created=" + created +
                '}';
    }

    public Goods() {
    }

    public Goods(Integer id, String name, Double price, Double costprice, Integer surplusnum, Integer allnum, Date created) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.costprice = costprice;
        this.surplusnum = surplusnum;
        this.allnum = allnum;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public Integer getSurplusnum() {
        return surplusnum;
    }

    public void setSurplusnum(Integer surplusnum) {
        this.surplusnum = surplusnum;
    }

    public Integer getAllnum() {
        return allnum;
    }

    public void setAllnum(Integer allnum) {
        this.allnum = allnum;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
