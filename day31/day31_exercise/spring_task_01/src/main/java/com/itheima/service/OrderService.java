package com.itheima.service;

import com.itheima.domain.Order;

public interface OrderService {
    /**
     * 根据订单ID查询订单信息
     * @param id
     * @return
     */
   public Order findById(Integer id);
}
