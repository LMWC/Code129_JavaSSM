package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Medal;
import com.itheima.domain.PageResult;
import com.itheima.mapper.MedalMapper;
import com.itheima.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MedalServiceImpl implements MedalService {

    @Autowired
    private MedalMapper medalMapper;

    public PageResult<Medal> findPage(Integer page, Integer pagesize) {
        IPage<Medal> ipage = new Page<Medal>(page,pagesize);
        ipage = medalMapper.selectPage(ipage,null);
        return new PageResult<Medal>(page,pagesize,ipage.getTotal(),ipage.getRecords());
    }

    public void edit(Medal medal) {
        medal.setUpdated(new Date());
        medalMapper.updateById(medal);
    }
}
