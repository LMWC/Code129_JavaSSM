package com.itheima.service.impl;

import com.itheima.annotation.RequiredLog;
import com.itheima.domain.Equipment;
import com.itheima.mapper.EquipmentMapper;
import com.itheima.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 减少库存
     * @param equipment
     */
    public void reduceStock(Equipment equipment) {
        equipmentMapper.reduceStock(equipment);
    }

    /**
     * 添加装备信息
     * @param equipment
     */
    @RequiredLog(operation = "addEquipment")
    public void addEquipment(Equipment equipment) {
        equipmentMapper.insert(equipment);
    }
}
