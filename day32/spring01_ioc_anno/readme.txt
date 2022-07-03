入门案例实现思路：
    1.创建Maven工程  添加依赖
    2.创建service接口及实现类
    3.创建dao接口及实现类
    4.在Spring配置文件中分别创建UserDaoImpl和UserServiceImpl的bean对象
        使用@Component注解替代bean标签创建类的对象 交给Spring IOC容器管理
    5.将UserDaoImpl对象注入到UserServiceImpl中
        使用@Autowired注解完成依赖注入
    6.运行测试【单元测试】

Spring注解方式实现入门案例：
    1.创建Maven工程  添加依赖
    2.创建service接口及实现类、dao接口及实现类
    3.分别在UserDaoImpl和UserServiceImpl类上打上@Component注解  用于创建对象交给Spring IOC容器管理
    4.在UserServiceImpl类中userDao属性上打上@Autowired注解 用于依赖注入
    5.在Spring配置文件中开启注解扫描
    6.运行测试

