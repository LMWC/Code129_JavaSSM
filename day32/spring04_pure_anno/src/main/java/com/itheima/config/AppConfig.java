package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/*
    @Configuration：打在类上 表示该类是一个配置类，可以取代applicationContext.xml配置文件
        是由@Component主键衍生出来的，因此Spring识别到类上有这个注解，就会创建该类的对象 放入到IOC容器中管理起来
    @ComponentScan("包名")：打在类上 开启组件扫描    让Spring主动去识别指定包及其子表下的java文件中有哪些注解，从而完成对应的操作
    @PropertySource("properties文件路径")：打在类上 引入外部properties文件
    @Import(Xxx.class)：打在类上 引入子配置类 替换import标签
 */

//@Import(AppConfig02.class)
@PropertySource("db.properties")
@ComponentScan("com.itheima")
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

    //创建DruidDataSource数据源对象
    /*
        @Bean：用于创建第三方jar包中类的对象 取代xml配置中bean标签
            作用：
                1.打在方法上 Spring识别到方法上有这个注解 就会将该方法的返回值放到IOC容器中管理起来
                2.bean的id默认为方法名称 也可以使用value属性指定bean的id
     */

    //@Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean("ds2")
    public DruidDataSource druidDataSource02(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    /*
        如果在@Bean注解所在方法内部 需要使用到IOC容器中管理的bean对象，该怎么办?
            解决方式：
                1.直接在当前方法上定义你要的参数即可 在参数前实际上隐藏了@Autowired注解
                2.万一 相同类型下有存在多个bean对象
                    2.1：投机取巧 设置参数的名称和某个bean对象的id相同
                    2.2：使用@Qualifier设置要去查找使用的bean的id
     */

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

}
