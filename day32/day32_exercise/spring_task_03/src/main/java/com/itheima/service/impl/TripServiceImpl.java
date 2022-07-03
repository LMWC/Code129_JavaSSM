package com.itheima.service.impl;

import com.itheima.domain.Trip;
import com.itheima.mapper.TripMapper;
import com.itheima.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripMapper tripMapper;

    public List<Trip> findAll() {
        return tripMapper.queryAll();
    }

    public int saveTrip(Trip trip) {
        return tripMapper.save(trip);
    }

    public Trip findById(Long id) {
        return tripMapper.queryById(id);
    }

    public int updateTrip(Trip trip) {
        return tripMapper.update(trip);
    }

    public int deleteById(Long id) {
        return tripMapper.deleteById(id);
    }
}
