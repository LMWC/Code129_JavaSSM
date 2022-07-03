package com.itheima.mapper;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface SysLogMapper {

    @Insert("insert into sys_log (username,operation,method,params,created) value(#{username},#{operation},#{method},#{params},#{created})")
    public Integer insert(SysLog sysLog);
}
