package com.itheima.service;

import com.itheima.domain.SysLog;

public interface SysLogService {
    /**
     * 保存日志记录
     * @param sysLog
     */
    public void insertLog(SysLog sysLog);
}
