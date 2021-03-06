package com.chas.model;

/**
 * Created by ShirUshI on 2017/5/15.
 */
public class Shop {

    private int id;

    private String name;

    private int star;

    private String city;

    private String distinct;

    private String detailAddr;

    private int commentNum;

    private int meanPrice;

    private String category;

    private double taste;

    private double envir;

    private double service;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistinct() {
        return distinct;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getMeanPrice() {
        return meanPrice;
    }

    public void setMeanPrice(int meanPrice) {
        this.meanPrice = meanPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
