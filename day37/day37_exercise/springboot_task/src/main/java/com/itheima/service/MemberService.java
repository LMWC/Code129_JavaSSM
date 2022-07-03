package com.itheima.service;
import com.itheima.domain.Member;

import java.util.List;

public interface MemberService {
    /**
     * 注册新员工
     * @param member
     * @return
     */
    public int save(Member member);
    /**
     * 查询员工列表
     * @return
     */
    public List<Member> findAll();

    /**
     * 修改员工信息
     * @param member
     * @return
     */
    public int update(Member member);

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    public int deleteById(Long id);
}
