package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;

public class OrderDaoImpl implements OrderDao {

    public Order queryById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setNumber("ORDER_"+System.currentTimeMillis());
        return order;
    }
}
