package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@ComponentScan("com.itheima")
@MapperScan("com.itheima.dao")
@PropertySource("classpath:db.properties")
@Configuration
public class AppConfig {

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /*=====================Spring整合MyBatis=====================*/
    //1.配置数据源bean对象 交由IOC容器管理
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //2.配置SqlSessionFactoryBean对象 交由IOC容器管理  【为了创建出SQLSessionFactory对象交由IOC容器管理】
    @Bean
    public SqlSessionFactoryBean sessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setTypeAliasesPackage("com.itheima.bean");
        return sfb;
    }

    //3.配置MapperScannerConfigurer对象 交由IOC容器管理   【为了扫描dao接口所在的包 创建dao接口代理对象 交给IOC容器管理】
    //@MapperScan("com.itheima.dao")


    /*=====================Spring事务管理=====================*/
    //1.配置事务管理员对象  MyBatis==》DataSourceTransactionManager
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    //2.使用注解@Transactional替代原来的事务规则配置以及aop配置
    /*
        @Transactional：打在类上、接口上、方法上，设置事务基本属性 取代原来xml中的事务规则配置以及aop配置
            打在接口上：对接口下所有实现类中的所有方法都应用这一套事务规则
            打在类上：只对当前类中的所有方法应用这一套事务规则
            打在方法上：只对当前方法应用这一套事务规则
                如果做粗粒度的事务控制：打在接口上  如果做细粒度的事务控制：打在方法上

     */

    //3.开启事务注解驱动支持 @EnableTransactionManagement

}
