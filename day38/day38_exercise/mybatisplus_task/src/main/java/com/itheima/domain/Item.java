package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class Item extends BasePojo{
    private Long id; //主键ID
    private String name; //商品名称
    private Long price; //商品价格
    private Integer stock; //商品库存
    private String image;  //商品图片地址
    private String category; //商品分类
    private String brand;  //商品品牌
    private Integer sold; //商品销量
    private Integer commentCount; //商品评论数
    @TableField("isAD")
    /**
     * 此处需要注意:MybatisPlus默认是支持驼峰模式,
     * isAD按照驼峰模式找对应的列名为 is_a_d和数据库表的列不一致
     * 所以@TableField不能省略
     */
    private Boolean isAD; //是否是首页推广广告，true/false
    private Integer status; //商品状态 1-正常，2-下架，3-删除
//	  因为继承了BasePojo，所以下面的属性与对应的方法都可以省略不写
//    @TableField(fill = FieldFill.INSERT) //FieldFill.INSERT指定为新增的时候自动填充
//    private Date createTime; //创建时间
//    @TableField(fill = FieldFill.INSERT_UPDATE) //FieldFill.INSERT_UPDATE指定为新增和修改的时候自动填充
//    private Date updateTime;//更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getAD() {
        return isAD;
    }

    public void setAD(Boolean AD) {
        isAD = AD;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", sold=" + sold +
                ", commentCount=" + commentCount +
                ", isAD=" + isAD +
                ", status=" + status +
                '}';
    }
}
