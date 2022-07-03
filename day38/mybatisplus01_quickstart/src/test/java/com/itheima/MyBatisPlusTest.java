package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserDao userDao;

    //增加
    @Test
    public void testInsert(){
        User user = new User(null, "吕龙飞", "666", "女", 19, "110");
        int rows = userDao.insert(user);
    }

    //修改
    @Test
    public void testUpdate(){
        User user = new User(1533625006284722177L, "吕飞飞", "666", "妖", 19, "110");
        userDao.updateById(user);
    }

    //根据id查询
    @Test
    public void testSelectById(){
        User user = userDao.selectById(4L);
        System.out.println("user = " + user);
    }

    //查询全部
    @Test
    public void testSelectList(){
        List<User> list = userDao.selectList(null);
        System.out.println("list = " + list);
    }

    //删除
    @Test
    public void testDelete(){
        userDao.deleteById(1533625006284722177L);
    }

    //分页查询
    @Test
    public void testSelectPage(){
        //创建分页工具类对象page  封装分页查询参数【当前页码、每页显示条数】
        Page<User> page = new Page<>(2,2);
        /*
        //设置当前页码
        page.setCurrent(2);
        //设置每页显示条数
        page.setSize(2);
        */

        //当调用了selectPage方法进行分页查询后，会自动的将当前页数据封装到page对象的records属性上
        userDao.selectPage(page, null);

        System.out.println("总条数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页数据集合 = " + page.getRecords());
    }


    //需求：查询年龄大于18岁 小于40岁的用户列表信息
    //方式一：使用QueryWrapper设置查询条件  完成条件查询操作
    //条件查询
    @Test
    public void testSelectByCondition01(){
        //1.创建QueryWrapper对象  【封装条件】
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //2.设置查询条件
        /*wrapper.gt("age",18);
        wrapper.lt("age",40);*/

        //支持链式编程
        wrapper.gt("age",18).lt("age",30);

        //3.调用方法 传入QueryWrapper对象
        List<User> list = userDao.selectList(wrapper);
        System.out.println("list = " + list);
    }

    //方式二：使用LambdaQueryWrapper设置查询条件  完成条件查询操作
    //条件查询
    @Test
    public void testSelectByCondition02(){
        //方式一：使用QueryWrapper对象得到LambdaQueryWrapper对象【不推荐】
       /* //1.创建QueryWrapper对象  【封装条件】
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<User> lambdaQueryWrapper = wrapper.lambda();
        //2.设置查询条件
        lambdaQueryWrapper.gt(User::getAge,18).lt(User::getAge,40);*/

        //方式二：直接创建LambdaQueryWrapper对象 设置查询条件  【推荐】
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.gt(User::getAge,18).lt(User::getAge,30);

        //3.调用方法 传入QueryWrapper对象
        List<User> list = userDao.selectList(lambdaQueryWrapper);
        System.out.println("list = " + list);
    }

    //需求：查询年龄大于30岁，小于 10岁的用户
    //条件查询-组合查询条件
    @Test
    public void testSelectByCondition03(){
        //1.创建Wrapper对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        //2.设置查询条件
        wrapper.gt(User::getAge,30).or().lt(User::getAge,10);

        //3.调用方法 传入Wrapper对象
        List<User> list = userDao.selectList(wrapper);
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    //条件查询-null值处理
    //需求：根据年龄查询用户信息, 如果年龄为null，表示查询表中所有数据
    @Test
    public void testSelectByCondition04(){
        //1.创建Wrapper对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        //2.设置查询条件
        Integer age = 18;

        //传统方式 null处理-- 使用if判断，显得代码臃肿
        /*if(age!=null){
            wrapper.gt(User::getAge,age);
        }*/

        //mybatisplus null处理 -- 简单清晰明了
        //参数1：condition 执行条件 boolean类型  当condition为true时，会设置查询条件，为false时，则不设置这个查询条件
        wrapper.gt(age!=null,User::getAge,age);


        //3.调用方法 传入Wrapper对象
        List<User> list = userDao.selectList(wrapper);
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    //条件查询-投影查询  查询部分数据
    //需求1：查询每个用户的name和age
    //分析：查询表中存在的部分列的数据  推荐使用LambdaQueryWrapper对象设置查询条件  可以避免字段名写错
    @Test
    public void testSelectByCondition05(){
        //1.创建wrapper对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        //2.设置查询条件  select()：设置查询字段
        wrapper.select(User::getName,User::getAge);


        /*QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name","age","tel");*/

        //3.调用方法 传入wrapper对象
        List<User> list = userDao.selectList(wrapper);
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    //需求2：查询总条数  select count(*) from user
    //分析：查询表中不存在的列数据 ，实体类中也不存在对应的属性，从而也不存在get方法，用不了Lambda的方法引用 推荐使用QueryWrapper对象设置查询条件
    /*
        实现方式：
            1.设置查询条件wrapper.select("count(*)"); 调用selectMaps(wrapper);方法
            2.使用selectCount()方法
     */
    @Test
    public void testSelectByCondition06(){
        //1.创建wrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //2.设置查询条件  select()：设置查询字段
        wrapper.select("count(*)");

        //3.调用方法 传入wrapper对象
        //表示将查询到字段及数据先封装到一个Map集合中【字段名作为key，查询结果作为value】，然后再存入到List集合中
        List<Map<String, Object>> maps = userDao.selectMaps(wrapper);
        System.out.println("maps = " + maps);


        //注意：此时由于没有设置查询条件 默认查询的是表中的总记录数
        /*Integer count = userDao.selectCount(null);
        System.out.println("count = " + count);*/
    }

    //需求：统计user表中男女分别有多少人
    //分析：使用分组查询  select gender,count(*) from user group by gender
    @Test
    public void testSelectByCondition07(){
        //1.创建wrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //2.设置查询条件
        // 2.1: 设置查询字段 select()
        wrapper.select("gender","count(*)");
        // 2.2: 设置分组查询
        wrapper.groupBy("gender");

        //3.调用方法 传入wrapper对象
        //表示将查询到字段及数据先封装到一个Map集合中【字段名作为key，查询结果作为value】，然后再存入到List集合中
        List<Map<String, Object>> maps = userDao.selectMaps(wrapper);
        System.out.println("maps = " + maps);

    }

    //需求：设置查询条件
    @Test
    public void testSelectByCondition08(){
        //1.创建wrapper对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();

        //2.设置查询条件
        //2.1：between
        wrapper.between(User::getAge,"18","30");

        //2.2:like
        //wrapper.like(User::getName,"龙");

        //2.3：orderby
        wrapper.orderByAsc(User::getAge);

        //3.调用方法 传入wrapper对象
        List<User> list = userDao.selectList(wrapper);
        for (User user : list) {
            System.out.println("user = " + user);
        }


    }
}
