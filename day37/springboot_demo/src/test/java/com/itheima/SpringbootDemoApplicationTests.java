package com.itheima;

import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
	@SpringBootTest：表示当前这个类使用SpringBoot整合Junit进行单元测试 会自动加载SpringBoot的主启动类【配置类】
	SpringBoot整合junit单元测试步骤：
		1.在src/test/java目录下创建一个测试类  在类上打上@SpringBootTest注解
		2.在测试方法上打上@Test注解
	注意：
		1.测试类【类上打有@SpringBootTest注解的类】一定要在主启动类的同级目录或是其子目录下
		2.如果测试类不在主启动类的同级目录或其子目录下，则需要设置@SpringBootTest注解的classes属性，主动加载SpringBoot项目主启动类
			eg:
				package com.shuaige;
				@SpringBootTest(classes = SpringbootDemoApplication.class)
				public class DemoTest {}
 */
@SpringBootTest
class SpringbootDemoApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		System.out.println("Hello SpringBoot");
	}

	@Test
	public void test01(){
		userService.add();
	}

}
