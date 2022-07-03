package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@MapperScan("com.itheima.dao")
@ComponentScan("com.itheima")
@PropertySource("classpath:db.properties")
@Configuration
public class SpringConfig {

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //1.创建数据源对象：Druid连接池对象  交由Spring IOC容器管理
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //2.加载数据源：创建SqlSessionFactoryBean工厂对象  从而通过SqlSessionFactoryBean工厂对象创建出SqlSessionFactory对象 交由Spring IOC容器管理
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //批量设置别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.itheima.bean");
        return sqlSessionFactoryBean;
    }


    /*
        现象：创建MapperScannerConfigurer对象的方法如果不加上static 则会报错 url not set
        原因：
            Cannot enhance @Configuration bean definition 'springConfig' since its singleton instance has been created too early.
            The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type:
            Consider declaring such methods as 'static'.
        分析：
            由于MapperScannerConfigurer类 实现了BeanDefinitionRegistryPostProcessor接口，
                导致了SpringConfig配置类必须尽早初始化，初始化时机太早了，属性都还没有赋值就已经初始化完成了
        解决：
            方式一：设置返回MapperScannerConfigurer类型数据的方法为静态方法
            方式二：直接将返回MapperScannerConfigurer类型数据的方法拆分另一个配置类中即可
            方式三：提前使用SpringBoot提供的一个注解 直接通过注解配置dao接口所在的包 完成扫描dao接口，创建代理对象 放入IOC容器管理
                    eg:@MapperScan("com.itheima.dao")  打在配置类上
     */

    //3.创建MapperScannerConfigurer对象 扫描dao接口所在的包 生成dao接口的代理对象 交由Spring IOC容器管理
    /*@Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }*/

}
