package com.itheima.bean;

import java.io.Serializable;

public class Address02 implements Serializable {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address02{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
