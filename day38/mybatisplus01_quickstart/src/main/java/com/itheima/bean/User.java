package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String gender;
    private Integer age;
    private String tel;
}
