package com.itheima.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


//@TableName("tbl_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    /*
        MyBatisPlus工作原理：根据调用的方法操作哪个实体类对应着操作表 【类名--表名  属性名称--字段名称】
        @TableField：设置类中属性和表中字段的映射关系，打在实体类属性上
            属性：
                value：设置当前属性对应的表中字段名称  如果属性和字段名称一致，可以省略不用设置
                exist：默认为true 表示表中存在对应的字段  设置为false，表示表中不存在对应的字段，不参与增删改查操作
                select：默认为true 表示该字段参与查询  设置为false，表示该字段不参与查询
        @TableName：打在类上 设置当前类对应数据库中的哪一张表

        @TableId：设置主键id生成策略，打在主键列对应的实体类属性上
            value：设置主键列名称 如果和属性名称一致 可以省略不用设置
            type：设置主键生成策略
                AUTO(0)：使用数据库自增  主键列为int、bigint
                NONE(1)：不设置主键自增策略 使用雪花算法
                INPUT(2)：手动输入设置主键
                ASSIGN_ID(3)：雪花算法   主键列为bigint、varchar
                ASSIGN_UUID(4)：UUID    主键列为varchar

        @TableLogic: 打在实体类逻辑删除字段对应的属性上
            value：未删除时的字段值
            delval：删除后的字段值
            逻辑删除实现步骤：
                1.表中添加逻辑删除字段
                2.实体类中添加对应属性 打上@TableLogic注解 设置删除和未删除时的字段值

        @Version:打在实体类版本号对应的属性上
            乐观锁实现步骤：
                1.表中添加版本号字段
                2.实体类中添加对应属性 打上@Version注解
                3.配置乐观锁拦截器

     */

    //设置主键id生成策略
    //@TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false)
    private String password;
    private String gender;
    private Integer age;
    private String tel;

    //扩展属性 数据库表中不存在
    @TableField(exist = false)
    private Integer online;

    //逻辑删除字段对应属性
    //@TableLogic(value = "0",delval = "1")
    private Integer deleted;

    //乐观锁字段对应属性
    @Version
    private Integer version;
}
