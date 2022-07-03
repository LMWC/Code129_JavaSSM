package com.itheima.mapper;

import com.itheima.domain.TripNewVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TripNewMapper {
    @Select("SELECT tn.id,tn.from_address fromAddress,tn.to_address toAddress, tn.start_time startTime,u.username,u.idcard,u.gender FROM tb_trip_new tn LEFT JOIN tb_user u ON tn.user_id = u.id")
    public List<TripNewVo> queryAll();
}
