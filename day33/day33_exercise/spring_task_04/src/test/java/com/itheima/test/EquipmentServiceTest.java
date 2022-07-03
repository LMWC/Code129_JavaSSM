package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Equipment;
import com.itheima.service.EquipmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class EquipmentServiceTest {

    @Autowired
    private EquipmentService equipmentService;

    @Test
    public void testAddEquipment(){
        Equipment equipment = new Equipment();
        equipment.setName("祝融之优品烈火剑");
        equipment.setUrl("http://tz.woniu.com/UserFiles/Image/tz/2011zlz/tzzlz2011/wuqi/image031.jpg");
        equipment.setStock(66);
        equipment.setPrice(8888L);
        equipment.setLevel(200);
        equipmentService.addEquipment(equipment);
    }
}
