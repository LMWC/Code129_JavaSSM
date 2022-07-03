package com.itheima.service;

import com.itheima.domain.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * 查询商品列表
     * @return
     */
    public List<Goods> findList();
}
