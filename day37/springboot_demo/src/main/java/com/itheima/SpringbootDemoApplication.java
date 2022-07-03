package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	@SpringBootApplication：SpringBoot应用注解
		@SpringBootConfiguration：由@Configuration注解衍生而来的，当类上有这个注解，则表示该类是SpringBoot的配置类，并且会自动创建该类的bean对象放入IOC容器中管理起来
			XxxApplication类：即是SpringBoot的启动类 也是SpringBoot项目的配置类
		@EnableAutoConfiguration：开启自动配置  SpringBoot的最大优点
		 	【SpringBoot如果发现你在项目中加入了某个starter，就会读取该starter或spring-boot-autoconfigure下面的META-INF下的spring.factories文件
		 		根据具体的类创建出bean对象加入IOC容器中管理起来 这样你在程序中就可以直接使用了  SPI：服务提供接口
		 	】
		@ComponentScan：组件扫描 默认的扫描规则：扫描当前类所在的包及其子包 创建bean对象放入IOC容器中管理
 */
@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
