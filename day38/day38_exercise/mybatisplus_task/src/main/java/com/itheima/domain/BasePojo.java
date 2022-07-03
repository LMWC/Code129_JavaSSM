package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class BasePojo {
    @TableField(fill = FieldFill.INSERT) //FieldFill.INSERT指定为新增的时候自动填充
    private Date createTime; //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE) //FieldFill.INSERT_UPDATE指定为新增和修改的时候自动填充
    private Date updateTime;//更新时间

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BasePojo{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
