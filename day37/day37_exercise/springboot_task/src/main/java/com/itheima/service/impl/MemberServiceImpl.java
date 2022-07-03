package com.itheima.service.impl;
import com.itheima.domain.Member;
import com.itheima.mapper.MemberMapper;
import com.itheima.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int save(Member member) {
        //对密码进行加密
        String newPwd = DigestUtils.md5DigestAsHex(member.getPassword().getBytes());
        member.setPassword(newPwd);
        return memberMapper.save(member);
    }
    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public int update(Member member) {
        return memberMapper.update(member);
    }

    @Override
    public int deleteById(Long id) {
        return memberMapper.deleteById(id);
    }

}
