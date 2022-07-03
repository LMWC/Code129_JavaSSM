package com.itheima.service;

import com.itheima.domain.Medal;
import com.itheima.domain.PageResult;

public interface MedalService {
    /**
     * 分页查询
     * @param page
     * @param pagesize
     * @return
     */
    public PageResult<Medal> findPage(Integer page, Integer pagesize);

    /**
     * 修改
     * @param medal
     */
    public void edit(Medal medal);
}
