package com.itheima.dao;

import com.itheima.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuaige
 * @since 2022-06-06
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
