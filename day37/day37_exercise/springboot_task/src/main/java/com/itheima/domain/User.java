package com.itheima.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String username;
    private Integer age;
    private String[] hobbies;
    private List<Hourse> hourses;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<Hourse> getHourses() {
        return hourses;
    }

    public void setHourses(List<Hourse> hourses) {
        this.hourses = hourses;
    }
}
