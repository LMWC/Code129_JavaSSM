package com.itheima.controller;

import com.itheima.domain.Medal;
import com.itheima.domain.PageResult;
import com.itheima.domain.Result;
import com.itheima.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/medal")
@RestController
public class MedalController {

    @Autowired
    private MedalService medalService;

    @GetMapping("/{page}/{pagesize}")
    public Result findPage(@PathVariable Integer page,@PathVariable Integer pagesize){
        try{
            PageResult<Medal> pageResult = medalService.findPage(page,pagesize);
            return new Result(true,"查询成功",pageResult);
        }catch (Exception e){
            return new Result(false,"查询失败",null);
        }
    }

    @PutMapping
    public Result edit(@RequestBody Medal medal){
        try {
            medalService.edit(medal);
            return new Result(true,"修改成功",null);
        }catch (Exception e){
            return new Result(false,"修改失败",null);
        }
    }
}
