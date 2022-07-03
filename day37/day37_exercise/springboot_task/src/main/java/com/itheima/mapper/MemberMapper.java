package com.itheima.mapper;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface MemberMapper {
    /**
     * 新增员工信息
     * @param member
     * @return
     */
    @Insert("insert into tbl_member(username,password,birthday,gender,email,phone,address) values(#{username},#{password},#{birthday},#{gender},#{email},#{phone},#{address})")
    public int save(Member member);

    /**
     * 查询所有员工列表
     * @return
     */
    @Select("select * from tbl_member")
    public List<Member> findAll();

    /**
     * 修改员工信息
     * @param member
     * @return
     */
    @Update("update tbl_member set username = #{username},birthday=#{birthday},gender=#{gender},email=#{email},phone=#{phone},address=#{address} where id = #{id}")
    public int update(Member member);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @Delete("delete from tbl_member where id = #{id}")
    public int deleteById(Long id);
}
