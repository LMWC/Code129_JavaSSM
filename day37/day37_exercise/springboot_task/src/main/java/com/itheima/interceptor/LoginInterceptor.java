package com.itheima.interceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.constant.ResultCode;
import com.itheima.domain.Member;
import com.itheima.domain.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //1.从session中获取登录信息
        Member member = (Member) request.getSession().getAttribute("member");
        //2.判断查询的结果是否为NULL
        if(member!=null){
            //3.不为NULL说明已经登录，放行
            return true;
        }
        //4.未登录
        Result result = new Result(ResultCode.NOLOGIN,"请先登录",null);
        //5.将result对象转换成json字符串
        String rst = objectMapper.writeValueAsString(result);
        //6.设置响应数据类型为 application/json并设置编码为utf-8
        response.setContentType("application/json;charset=utf-8");
        //7.将数据写回前端
        response.getWriter().write(rst);
        //8.拦截
        return false;
    }
}
