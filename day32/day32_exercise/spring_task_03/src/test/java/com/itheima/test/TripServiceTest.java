package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Trip;
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
public class TripServiceTest {

    @Autowired
    private TripService tripService;

    @Test
    public void testFindAll(){
        List<Trip> list = tripService.findAll();
        for (Trip trip : list) {
            System.out.println(trip);
        }
    }

    @Test
    public void testAdd(){
        Trip trip = new Trip();
        trip.setUsername("TOM");
        trip.setGender(1);
        trip.setIdcard("61011220000202X");
        trip.setFromAddress("西安");
        trip.setToAddress("北京");
        trip.setStartTime(new Date());
        int rst = tripService.saveTrip(trip);
        System.out.println(rst);
    }

    @Test
    public void testFindById(){
        Trip trip = tripService.findById(16L);
        System.out.println(trip);
    }

    @Test
    public void testUpdate(){
        Trip trip = tripService.findById(16L);
        trip.setFromAddress("深圳");
        trip.setToAddress("西安");
        int rst = tripService.updateTrip(trip);
        System.out.println(rst);
    }

    @Test
    public void testDeleteById(){
        int rst = tripService.deleteById(16L);
        System.out.println(rst);
    }
}
