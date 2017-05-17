package com.chas.model;

import java.sql.Date;

/**
 * Created by ShirUshI on 2017/5/15.
 */
public class Comment {

    private int id;

    private int shopId;

    private int contribution;

    private int remark;

    private double taste;

    private double envir;

    private double service;

    private String detail;

    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    public double getTaste() {
        return taste;
    }

    public void setTaste(double taste) {
        this.taste = taste;
    }

    public double getEnvir() {
        return envir;
    }

    public void setEnvir(double envir) {
        this.envir = envir;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
