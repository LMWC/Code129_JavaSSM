package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
//TODO:构建数据库连接池对象DataSource
public class JdbcConfig {
    //1.驱动
    @Value("${jdbc.driver}")
    private String driver;
    //2.url地址
    @Value("${jdbc.url}")
    private String url;
    //3.用户名
    @Value("${jdbc.username}")
    private String userName;
    //4.用户密码
    @Value("${jdbc.password}")
    private String password;

    @Bean
    //构建DataSource对象
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}