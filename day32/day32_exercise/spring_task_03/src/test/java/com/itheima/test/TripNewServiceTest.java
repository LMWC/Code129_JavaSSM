package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Trip;
import com.itheima.domain.TripNewVo;
import com.itheima.service.TripNewService;
import com.itheima.service.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TripNewServiceTest {

    @Autowired
    private TripNewService tripNewService;

    @Test
    public void testFindAll(){
        List<TripNewVo> list = tripNewService.findAll();
        for (TripNewVo tripVo : list) {
            System.out.println(tripVo);
        }
    }

}
