SSM整合环境搭建流程：
    环境搭建：
        1.创建数据库、表、插入测试数据
        2.创建Maven工程【javaweb】 添加依赖【springmvc、spring、mybatis、spring整合mybatis相关】
        3.添加静态资源到项目的webapp目录下
        4.编写配置文件
            SpringMVC：springmvc.xml【引入applicationContext.xml配置文件】、web.xml
            Spring：applicationContext.xml【整合MyBatis】
            MyBatis：db.properties 、 log4j.properties
        5.创建项目包结构：
    功能开发：
        1.创建实体类 Book
        2.添加工具类 Result、Code
        3.编写dao接口并配置方法映射SQL语句
        4.编写Service接口及实现类
        5.编写Controller方法接收请求处理


