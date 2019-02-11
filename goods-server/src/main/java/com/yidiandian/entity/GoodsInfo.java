package com.yidiandian.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: 一点点
 * @Date: 2019/1/29 21:56
 * @Version 1.0
 */
@Entity
public class GoodsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String goodId;
    private String goodName;

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", goodId='" + goodId + '\'' +
                ", goodName='" + goodName + '\'' +
                '}';
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
