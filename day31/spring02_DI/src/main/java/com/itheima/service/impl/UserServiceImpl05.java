package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

import java.util.*;

public class UserServiceImpl05 implements UserService {

    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,Object> map;
    private Properties p;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl05的add方法~~~ ");
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("list = " + list);
        System.out.println("set = " + set);
        System.out.println("map = " + map);
        System.out.println("p = " + p);
    }
}
