package com.itheima.dao;

import com.itheima.domain.Order;

public interface OrderDao {
    /**
     * 根据ID查询订单信息
     * @param id
     * @return
     */
    public Order queryById(Integer id);
}
