package com.itheima.domain;

import java.util.Date;

public class Order {

    private Long id;
    private String serialNum;
    private Long equipmentId;
    private Integer num;
    private Date created;
    private Date updated;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", serialNum='" + serialNum + '\'' +
                ", equipmentId=" + equipmentId +
                ", num=" + num +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
