package com.itheima.service.impl;

import com.itheima.dao.GoodsDao;
import com.itheima.domain.Goods;
import com.itheima.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    //TODO:setter方式注入GoodsDao
    //1.声明私有属性
    private GoodsDao goodsDao;
    //2.提供对应的setter方法
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public List<Goods> findList() {
        //TODO:调用GoodsDao的查询列表方法
        //3.调用GoodsDao的queryList方法查询商品列表数据
        return goodsDao.queryList();
    }
}
