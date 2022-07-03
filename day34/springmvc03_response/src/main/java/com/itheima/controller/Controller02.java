package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
    响应视图和数据:
        方式一：在方法中创建ModelAndView对象 用于封装数据和视图返回即可
        方式二：在方法形参上定义ModelAndView对象参数 SpringMVC就会自己创建好ModelAndView对象传递进来
        方式三：可以在方法形参上定义Model对象参数  SpringMVC就会创建好Model对象传递进来 使用Model对象保存数据【保存在request域对象中】
        方式四：直接使用request域对象中存储数据，返回逻辑视图名称
    注意：
        1.SpringMVC中视图的跳转默认使用请求转发
 */
@Controller
public class Controller02 {

    //方式一：
    @RequestMapping("/page05")
    public ModelAndView page05(){
        System.out.println("page05....");

        //1.创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        //2.封装数据和视图名称
        mv.addObject("name","zhangsan");
        mv.setViewName("success");

        //3.返回ModelAndView对象
        return mv;
    }

    //方式二：
    @RequestMapping("/page06")
    public ModelAndView page06(ModelAndView mv){
        System.out.println("page06....");

        //2.封装数据和视图名称
        mv.addObject("name","lisi");
        mv.setViewName("success");

        //3.返回ModelAndView对象
        return mv;
    }

    //方式三：
    @RequestMapping("/page07")
    public String page07(Model model){
        System.out.println("page07....");

        //2.使用model对象封装数据
        model.addAttribute("name","wangwu");

        //3.响应逻辑视图名称
        return "success";
    }

    //方式四：
    @RequestMapping("/page08")
    public String page08(HttpServletRequest request){
        System.out.println("page08....");

        //2.使用request域对象封装数据
        request.setAttribute("name","zhaoliu");

        //3.响应逻辑视图名称
        return "success";
    }

}
