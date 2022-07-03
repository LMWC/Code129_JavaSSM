package com.itheima.service;

import com.itheima.domain.TripNewVo;

import java.util.List;

public interface TripNewService {
    /**
     * 查询所有的旅程数据
     * @return
     */
    public List<TripNewVo> findAll();
}
