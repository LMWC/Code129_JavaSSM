package com.itheima.dao.impl;

import com.itheima.dao.GoodsDao;
import com.itheima.domain.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    public List<Goods> queryList() {
        List<Goods> list = new ArrayList<Goods>();
        for (int i = 0; i < 5; i++) {
            list.add(new Goods(i+1,"华为荣耀P3"+i));
        }
        return list;
    }
}
