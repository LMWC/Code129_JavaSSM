package com.itheima.service.impl;

import com.itheima.annotation.RequiredLog;
import com.itheima.domain.Equipment;
import com.itheima.domain.Order;
import com.itheima.mapper.OrderMapper;
import com.itheima.service.EquipmentService;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 下订单并减库存
     * @param order
     */
    @Transactional
    public void addOrder(Order order) {
        //1.下订单
        orderMapper.insert(order);
        //2.减少库存
        Equipment equipment = new Equipment();
        equipment.setStock(order.getNum());
        equipment.setId(order.getEquipmentId());
        equipment.setCreated(new Date());
        equipment.setUpdated(new Date());
        equipmentService.reduceStock(equipment);
    }
}
