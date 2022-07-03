package com.itheima.controller;

import com.itheima.constant.ResultCode;
import com.itheima.domain.Member;
import com.itheima.domain.Result;
import com.itheima.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public Result add(@RequestBody Member member){
        memberService.save(member);
        return new Result(ResultCode.SUCCESS,"注册成功",null);
    }
    @GetMapping("/findAll")
    public Result findAll(){
        List<Member> list = memberService.findAll();
        return new Result(ResultCode.SUCCESS,"查询成功",list);
    }
    @PutMapping
    public Result update(@RequestBody Member member){
        memberService.update(member);
        return new Result(ResultCode.SUCCESS,"修改成功",null);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Long id){
        memberService.deleteById(id);
        return new Result(ResultCode.SUCCESS,"删除成功",null);
    }
}
