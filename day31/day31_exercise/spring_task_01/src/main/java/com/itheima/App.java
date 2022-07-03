package com.itheima;

import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //TODO:加载Spring容器,从容器中获取OrderService对象完成根据订单ID查询订单信息并把结果打印到控制台
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService)ctx.getBean("orderService");
        Order order = orderService.findById(1);
        System.out.println(order);
    }
}