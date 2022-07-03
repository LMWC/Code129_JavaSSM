package com.itheima.controller;

import com.itheima.domain.Goods;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    /**
     * 查询所有商品列表
     */
    @GetMapping
    public List<Goods> findAll(){
        List<Goods> list = getAll();
        return list;
    }


    /**
     * 新增商品信息，@RequestBody用来接收前端发送的json数据
     */
    @PostMapping
    public String addGoods(@RequestBody Goods goods){
        System.out.println(goods);
        return "success";
    }

    /**
     * 修改商品信息
     */
    @PutMapping
    public String editGoods(@RequestBody Goods goods){
        System.out.println(goods);
        return "success";
    }
    /**
     * 删除商品信息
     */
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        System.out.println("删除的商品ID为:"+id);
        return "success";
    }

    private List<Goods> getAll(){
        List<Goods> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Goods goods = new Goods(i+1,"华为手机META5"+i,2000.0+i,1000.0+i,2000+i,3000+i,new Date());
            list.add(goods);
        }
        return list;
    }
}
