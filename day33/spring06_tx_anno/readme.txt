Spring整合MyBatis环境搭建：
 1.准备数据库 表 插入测试数据 day32
 2.创建项目 添加依赖
 3.创建包结构
    com.itheima.bean：Account
    com.itheima.dao：AccountDao
    com.itheima.service：AccountService 、 AccountServiceImpl
 4.编写dao接口映射文件|使用注解配置SQL语句
 5.添加配置文件
    mybatis：mybatis-config.xml、db.properties、log4j.properties
    spring：applicationContext.xml


Spring整合MyBatis的目的是为了：在Service层调用dao层操作数据库时，可以直接将dao层接口下的代理对象直接注入到Service类中 方便直接使用。
    MyBatis核心程序：
        1.加载MyBatis配置文件，得到SqlSessionFactory对象    --> SqlSession对象
        2.使用sqlSession对象，根据dao接口得到代理对象        -->  调用方法完成操作
    MyBatis配置文件：
        1.数据库环境【连接池】     -->   知道操作哪个数据库
        2.扫描dao接口的包         -->   知道有哪些dao接口
    现在：Spring整合MyBatis
        加载MyBatis配置文件，【数据库环境和扫描dao接口】 希望Spring加载MyBatis配置文件
        得到SqlSessionFactory对象，放入IOC容器中管理起来
        得到SqlSession对象，放入IOC容器中管理起来
        将dao接口的代理对象放入IOC容器中管理起来
    精简：
        1.Spring加载数据库信息 得到连接池对象
        2.Spring要托管SqlSessionFactory对象
        3.Spring要托管dao接口的代理对象




