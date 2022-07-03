package com.itheima.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "enterprise")
@Component
@Data
public class Enterprise {
    private String name;
    private Integer age;
    private String tel;
    private String[] subject;
}
