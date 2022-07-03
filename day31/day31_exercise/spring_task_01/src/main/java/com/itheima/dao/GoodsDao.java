package com.itheima.dao;

import com.itheima.domain.Goods;

import java.util.List;

public interface GoodsDao {
    /**
     * 查询商品列表
     * @return
     */
    public List<Goods> queryList();
}
