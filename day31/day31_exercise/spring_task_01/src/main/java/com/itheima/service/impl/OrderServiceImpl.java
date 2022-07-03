package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Goods;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.service.GoodsService;
import com.itheima.service.OrderService;
import com.itheima.service.UserService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    //TODO:setter方式注入OrderDao
    //1.声明私有属性
    private OrderDao orderDao;
    //TODO:setter方式注入UserService
    //1.声明私有属性
    private UserService userService;
    //TODO:setter方式注入GoodsService
    //1.声明私有属性
    private GoodsService goodsService;

    //2.提供对应的setter方法
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    //2.提供对应的setter方法
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    //2.提供对应的setter方法
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public Order findById(Integer id) {
        //TODO:调用OrderDao方法，根据ID查询订单信息
        //3.调用OrderDao的queryById方法查询订单信息
        Order order = orderDao.queryById(id);
        //TODO:调用UserService方法查询订单所属用户信息，并将用户信息设置到Order对象中
        //4.调用UserService的findUser方法，完成用户信息查询
        User user = userService.findUser();
        //5.将user数据设置到order对象中
        order.setUser(user);
        //TODO:调用GoodsService方法查询订单所包含的商品列表，并将商品列表设置到Order对象中
        //6.调用GoodsService的findList方法，完成商品列表数据查询
        List<Goods> list = goodsService.findList();
        //7.将商品列表数据设置到order对象中
        order.setGoodsList(list);
        //8.将order对象进行返回
        return order;
    }
}