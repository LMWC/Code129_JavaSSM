1.入门案例制作：springboot01_quickstart、springboot02_quickstart、springboot_demo
2.基础配置：springboot04_config
3.整合junit：springboot_demo
4.整合MyBatis：springboot05_mybatis
    1.创建Maven项目 勾选技术依赖 mybatis、mysql驱动
    2.在SpringBoot项目的application.yml文件中配置数据源
    3.编写javabean、dao接口
    4.dao接口上打上@Mapper注解|SpringBoot启动类上打上@MapperScan("com.itheima.dao")
    5.运行测试了
    整合细节处理：
        细节1：由于SpringBoot版本较高，使用的是8.x版本的MySQL驱动jar包 所以数据源驱动类应该使用com.mysql.cj.jdbc.Driver
        细节2：SpringBoot项目默认使用hikari连接池【数据源】  如果你没有指定，用的就是hikariCP，这个是最棒的
               1：性能方面 hikariCP>druid>tomcat-jdbc>dbcp>c3p0 。hikariCP的高性能得益于最大限度的避免锁竞争。
               2：druid功能最为全面，sql拦截等功能，统计数据较为全面，具有良好的扩展性。
               3：综合性能，扩展性等方面，可考虑使用druid或者hikariCP连接池。
              如果想使用druid连接池：
                1.添加druid依赖
                2.配置数据源类型type属性
        细节3：MyBatis 别名、映射文件以及SQL语句日志打印设置
            mybatis:
              # 使用包 批量设置别名
              type-aliases-package: com.itheima.bean
              # 设置mapper映射文件路径
              mapper-locations: com/shuaige/*Dao.xml
              # 方便调试 会打印SQL语句到日志中
              configuration:
                log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
        细节4：一般不建议在dao接口上打@Mapper注解，建议直接在SpringBoot启动类上打上@MapperScan("com.itheima.dao") 扫描dao接口所在的包