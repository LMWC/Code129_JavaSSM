package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*
   @Autowired：
     作用：Spring一旦在某个属性或某个参数前识别到存在该注解，就会自动根据类型去IOC容器中找到对应的bean对象注入进来
     工作原理：
        1.先根据类型查找，如果指定类型下只有一个满足的bean对象，则正常注入
        2.如果该类型下有多个满足的bean对象，会使用当前属性的名称作为bean的id去查找，找到就正常注入，找不到就报错
     当相同类型下出现多个bean对象时，直接使用@Autowired注入数据则会报错，如何解决呢？
        方式一：保证相同类型下只有一个bean对象
        方式二：从多个bean对象中选择一个设置bean对象的id和属性名称一致
        方式三：使用@Qualifier注解  通过@Qualifier注解设置要查找的bean的id值
            @Qualifier注解：打辅助 配和@Autowired一起使用
                value属性：指定要查找注入进来的bean的id
     注意：
        1.使用Spring创建对象并管理时 一般建议一个类型下只存在一个对象
        2.使用@Autowired注解自动为bean对象的属性注入数据时 只能注入IOC容器中管理的bean对象
        3.使用@Autowire注解为属性注入数据  可以省略set方法

    @Resource：相当于@Autowired+@Qualifier    这个注解是由JDK提供的，但是Spring认识，可以识别使用
        作用：用于为bean对象的引入属性注入IOC容器中管理的数据
        工作原理：
            1.先按名称作为bean的id去查找，如果在IOC容器中存在相同id名称的bean对象，则正常注入
            2.如果没有相同名称的bean对象，再根据类型查找，根据类型查找时，如果只有一个，则正常注入
            3.如果一个类型下存在多个，则会报错
        属性：
            name：指定bean的id值  一旦指定了bean的id，Spring就会根据name属性值作为bean的id去IOC容器中查找对应的bean对象注入

    @Value注解：
        作用：为一个bean对象的简单类型属性注入数据
        使用场景：一般用于获取properties配置文件中的数据注入到简单类型属性中
        使用步骤：
            1.准备一个properties文件
            2.在Spring中引入properties文件
            3.使用@Value("${properties.key}")注解获取properties文件中指定key的值注入到属性中
 */

@Service
public class UserServiceImpl implements UserService {

    /*@Autowired
    @Qualifier("userDaoImpl02")
    private UserDao userDao;*/

    @Resource(name="userDaoImpl02")
    private UserDao userDao;

    @Value("张静")
    private String username;

    @Value("桥下")
    private String address;

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~ ");
        System.out.println(username + " " + address);
        System.out.println("driverClass = " + driverClass);
        System.out.println("url = " + url);
        System.out.println("user = " + user);
        System.out.println("password = " + password);


        userDao.add();
    }
}
