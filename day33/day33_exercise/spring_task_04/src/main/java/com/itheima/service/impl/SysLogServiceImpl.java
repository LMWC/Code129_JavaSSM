package com.itheima.service.impl;

import com.itheima.domain.SysLog;
import com.itheima.mapper.SysLogMapper;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    public void insertLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }
}
