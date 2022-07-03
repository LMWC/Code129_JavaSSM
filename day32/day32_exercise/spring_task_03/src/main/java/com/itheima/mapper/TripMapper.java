package com.itheima.mapper;

import com.itheima.domain.Trip;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TripMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select id,username,gender,idcard,from_address fromAddress,to_address toAddress,start_time startTime from tb_trip")
    public List<Trip> queryAll();

    /**
     * 新增
     * @param trip
     * @return
     */
    @Insert("insert into tb_trip values(null,#{username},#{gender},#{idcard},#{fromAddress},#{toAddress},#{startTime})")
    public int save(Trip trip);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Select("select id,username,gender,idcard,from_address fromAddress,to_address toAddress,start_time startTime from tb_trip where id = #{id}")
    public Trip queryById(Long id);

    /**
     * 修改
     * @param trip
     * @return
     */
    @Update("update tb_trip set username =#{username},gender=#{gender},idcard=#{idcard},from_address=#{fromAddress},to_address=#{toAddress},start_time = #{startTime} where id =#{id}")
    public int update(Trip trip);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @Delete("delete from tb_trip where id = #{id}")
    public int deleteById(Long id);
}
