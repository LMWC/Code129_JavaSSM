package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_medal")
public class Medal {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String url;
    private String name;
    private String country;
    private Integer gold;
    private Integer silver;
    private Integer bronze;
    private Integer total;
    private Integer ranking;
    private Date created;
    private Date updated;
}
