package com.itheima.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component //让Spring来管理该类
public class MyMetaObjectHandler implements MetaObjectHandler{

    /**
     * 在执行新增的时候会自动执行的方法，在该方法中为createTime与updateTime进行设值
     * @param metaObject 元数据
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        /**
         * 新增填充,参数一:元数据，参数二:填充的字段属性名称，参数三:填充值的类型，参数四:填充具体的值
         */
        this.strictInsertFill(metaObject,"createTime",Date.class,new Date());
        /**
         * 修改填充,参数一:元数据，参数二:填充的字段属性名称，参数三:填充值的类型，参数四:填充具体的值
         */
        this.strictUpdateFill(metaObject,"updateTime",Date.class,new Date());
    }

    /**
     * 在执行修改的时候会自动执行的方法，在该方法中为updateTime进行设置
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        /**
         * 修改填充,参数一:元数据，参数二:填充的字段属性名称，参数三:填充值的类型，参数四:填充具体的值
         */
        this.strictUpdateFill(metaObject,"updateTime",Date.class,new Date());
    }
}
