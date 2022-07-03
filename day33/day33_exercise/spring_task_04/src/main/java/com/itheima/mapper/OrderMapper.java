package com.itheima.mapper;

import com.itheima.domain.Order;
import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {
    /**
     * 新增
     * @param order
     * @return
     */
    @Insert("insert into tb_order(serial_num,equipment_id,num,created,updated) value(#{serialNum},#{equipmentId},#{num},#{created},#{updated})")
    public Integer insert(Order order);
}
