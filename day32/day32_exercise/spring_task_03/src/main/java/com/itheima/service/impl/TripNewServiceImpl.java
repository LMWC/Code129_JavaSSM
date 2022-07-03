package com.itheima.service.impl;

import com.itheima.domain.TripNewVo;
import com.itheima.mapper.TripNewMapper;
import com.itheima.service.TripNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripNewServiceImpl implements TripNewService {
    @Autowired
    private TripNewMapper tripNewMapper;

    public List<TripNewVo> findAll() {
        return tripNewMapper.queryAll();
    }
}
