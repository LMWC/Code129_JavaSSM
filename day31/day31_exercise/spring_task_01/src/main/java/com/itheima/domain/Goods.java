package com.itheima.domain;

public class Goods {

    private Integer id; //商品ID
    private String goodsName;//商品名称

    public Goods(Integer id, String goodsName) {
        this.id = id;
        this.goodsName = goodsName;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
