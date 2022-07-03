package com.itheima.mapper;

import com.itheima.domain.Equipment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EquipmentMapper {

    /**
     * 减库存
     * @param equipment
     * @return
     */
    @Update("update tb_equipment set stock = stock-#{stock},created=#{created},updated=#{updated} where id = #{id}")
    public Integer reduceStock(Equipment equipment);

    @Insert("insert into tb_equipment (name,url,level,price,stock,created,updated) value (#{name},#{url},#{level},#{price},#{stock},#{created},#{updated})")
    public void insert(Equipment equipment);
}
