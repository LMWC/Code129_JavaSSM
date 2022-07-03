package com.itheima.controller;

import com.itheima.bean.User;
import com.itheima.bean.User02;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class Controller01 {

    @RequestMapping("/sayHi")
    public String sayHi(){
        System.out.println("Controller01 sayHi...");
        return "success";
    }

    /*
        1.获取普通格式参数
            注意：
                1.直接在方法上定义形参
                2.形参的名称和请求参数名称一致  就可以将请求参数赋值到方法形参上
                3.如果前端发起请求没有携带name和age参数  则默认为null,由于age参数类型时int，null不能转为int，所以报错
                   因此：我们建议接收请求参数一般使用引用类型
                4.如果前端发起请求携带的参数多了 也没有影响 后台只接收定义的形参匹配的参数
     */
    @RequestMapping("/getCommonParam01")
    public String getCommonParam01(String name,Integer age){
        System.out.println("=====1.获取普通格式参数=====");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "success";
    }

    /*
        1.获取普通格式参数
            问题：请求参数名称和形参名称不一致  导致无法接收请求参数数据
            解决：
                设置请求参数名称和形参名称一致就可以了
                使用@RequestParam注解设置形参别名和请求参数名称保持一致，这样就可以接收到请求参数数据了
           @RequestParam： 打在方法形参前面，为形参设置别名和请求参数名称一致  解决请求参数名称和形参名称不一致 ，接收不到请求参数的问题
                属性：
                    name|value：设置请求参数名称
                    required：设置当前这个参数是否是必要的
                        默认为true，是必须的  请求时必须携带该参数
                        false：不是必须的  请求时可以无需携带该参数
                        defaultValue：设置参数默认值 当没有携带该参数时，设置参数值为默认的值

     */
    @RequestMapping("/getCommonParam02")
    public String getCommonParam02(@RequestParam(value = "name",required = false,defaultValue = "shuaige") String username, Integer age){
        System.out.println("=====1.获取普通格式参数=====");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "success";
    }

    /*
        1.2获取pojo类型参数
            实现：1.在方法上定义一个对象类型的形参 2.形参对象的属性名称和请求参数名称一致
   */
    @RequestMapping("/getObjectParam03")
    public String getCommonParam03(User user){
        System.out.println("=====2.获取pojo类型参数=====");
        System.out.println("user = " + user);
        return "success";
    }

    /*
        1.2获取嵌套pojo类型参数
            实现：1.在方法上定义一个对象类型的形参
                 2.形参对象的属性名称和请求参数名称一致
                    2.1：普通属性和请求参数名称一致  eg:name、age
                    2.2：对象属性和请求参数名称一致  eg：address.province  address.city
   */
    @RequestMapping("/getObjectParam04")
    public String getCommonParam04(User02 user){
        System.out.println("=====3.获取嵌套pojo类型参数=====");
        System.out.println("user = " + user);
        return "success";
    }

    /*
        1.4获取数组类型参数
            要求：
                1.方法形参设置为数组类型
                2.形参变量名称和请求参数名称一致  同一个请求参数名称下，对应的有多个值

   */
    @RequestMapping("/getArrayParam05")
    public String getArrayParam05(String[] hobby){
        System.out.println("=====4.获取数组类型参数=====");
        System.out.println("hobby = " + Arrays.toString(hobby));
        return "success";
    }

    /*
        1.5获取List集合类型参数
            要求：
                1.方法形参设置为List集合类型
                2.形参变量名称和请求参数名称一致
            注意：
                前端发送请求携带请求参数 不能自动的封装到List集合变量上
                如果你想将请求参数封装到List集合变量中，需要使用@RequestParam注解完成
   */
    @RequestMapping("/getListParam06")
    public String getListParam06(@RequestParam List<String> hobby){
        System.out.println("=====5.获取List集合类型参数=====");
        System.out.println("hobby = " + hobby);
        return "success";
    }

    /*
        1.6获取日期类型参数
            要求：
                1.方法形参设置为Date日期类型
                2.形参变量名称和请求参数名称一致
            注意：
                1.SpringMVC默认支持将yyyy/MM/dd格式的日期字符串转为Date类型 其他格式不支持【报400错误】
                    原因：SpringMVC偷懒了  前端：所有参数都是字符串  后台：SpringMVC接收字符串参数转为指定的java类型数据处理
                    因此：SpringMVC中提供了大量的类型转换器  但是对日期这一块的支持比较弱
                    解决：
                        1.接收日期类型参数时  设置日期字符串格式 让SpringMVC根据我们指定的日期字符串格式将其转为Date类型
                            @DateTimeFormat：设置日期字符串参数格式 封装到一个Date类型参数中
                                pattern：设置日期格式
                        2.设置全局日期转换器

   */
    @RequestMapping("/getDateParam07")
    public String getDateParam07(Date date01, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date02,@DateTimeFormat(pattern = "yyyy年MM月dd日") Date date03){
        System.out.println("=====6.获取日期类型参数=====");
        System.out.println("date01 = " + date01);
        System.out.println("date02 = " + date02);
        System.out.println("date03 = " + date03);
        return "success";
    }

    /*
       1.7获取json格式参数
            实现步骤：
                1.前端发送ajax请求携带json格式参数【post】
                2.项目中添加jackson-databind依赖
                3.开启MVC注解驱动
                4.在方法形参前打上@RequestBody注解
         @RequestBody：请求体【get方式没有请求体 post方式有请求体 请求体中存放的就是请求参数】
            作用：将请求体中的json格式参数携带到后台 赋值给形参java对象  json--SpringMVC自动完成-->java对象
            注意：打在方法形参前面，一个方法中，该注解只能使用一次
        细节：
            1.项目没有添加jackson-databind依赖：报415 请求参数内容类型和服务器设置的不一致
            2.没有开启MVC注解驱动：报404
            3.方法形参前没有打@RequestBody注解：报500|接收不到请求参数
     */
    //普通json数组
    @RequestMapping("/getJsonParam08")
    public String getJsonParam08(@RequestBody List<String> names){
        System.out.println("=====7.获取普通json数组参数=====");

        System.out.println("names = " + names);

        return "success";
    }

    //json对象
    @RequestMapping("/getJsonParam09")
    public String getJsonParam09(User user){
        System.out.println("=====7.获取json对象参数=====");

        System.out.println("user = " + user);

        return "success";
    }

    //json对象数组
    @RequestMapping("/getJsonParam10")
    public String getJsonParam10(@RequestBody List<User> users){
        System.out.println("=====7.获取json对象数组参数=====");

        System.out.println("users = " + users);

        return "success";
    }

}
