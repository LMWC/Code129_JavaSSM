package com.itheima.service;

import com.itheima.domain.Trip;

import java.util.List;

public interface TripService {
    /**
     * 查询所有
     * @return
     */
    public List<Trip> findAll();

    /**
     * 新增
     * @param trip
     * @return
     */
    public int saveTrip(Trip trip);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Trip findById(Long id);

    /**
     * 修改
     * @param trip
     * @return
     */
    public int updateTrip(Trip trip);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int deleteById(Long id);
}
