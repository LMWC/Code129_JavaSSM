package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void testAddOrder(){
        Order order = new Order();
        //使用UUID生成一个唯一的订单号
        String serialNum = UUID.randomUUID().toString().replace("-", "");
        order.setSerialNum(serialNum);
        order.setEquipmentId(1L);
        order.setNum(100);
        order.setCreated(new Date());
        order.setUpdated(new Date());
        //下订单
        orderService.addOrder(order);
    }
}
