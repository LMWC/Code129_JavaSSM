package com.itheima.service;

import com.itheima.domain.Equipment;

public interface EquipmentService {

    /**
     * 减少库存
     * @param equipment
     */
    public void reduceStock(Equipment equipment);

    /**
     * 添加装备信息
     * @param equipment
     */
    public void addEquipment(Equipment equipment);
}
