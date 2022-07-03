package com.itheima.bean;

import java.io.Serializable;

public class User02 implements Serializable {
    private String name;
    private Integer age;
    private Address02 address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address02 getAddress() {
        return address;
    }

    public void setAddress(Address02 address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User02{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
