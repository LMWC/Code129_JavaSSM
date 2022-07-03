Spring IOC|DI注解方式入门案例：
    需求：采用Spring注解方式实现在UserServiceImpl类中使用UserDaoImpl对象调用add方法
    xml方式配置实现：
        1.创建Maven工程 添加依赖
        2.创建UserService接口和实现类UserServiceImpl
        3.创建UserDao接口和实现类UserDaoImpl
        4.创建Spring配置文件
        5.定义UserServiceImpl和UserDaoImpl两个实现类bean 交给Spring IOC容器管理
        6.在UserServiceImpl类中定义一个UserDao属性  创建UserServiceImpl的bean对象时将UserDao注入进去
        7.运行测试

    注解方式实现：
        1.创建Maven工程 添加依赖
        2.创建UserDao接口和实现类UserDaoImpl
        3.创建UserService接口和实现类UserServiceImpl，在实现类中定义一个UserDao属性
        4.在UserDaoImpl和UserServiceImpl类上打上@Component注解
        5.在UserServiceImpl类中的UserDao属性上打上@Autowired注解
        6.创建spring配置文件 在配置文件中配置Spring要扫描的包【开启注解扫描】
        7.运行测试

