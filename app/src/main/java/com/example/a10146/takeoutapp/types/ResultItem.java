package com.example.a10146.takeoutapp.types;

public class ResultItem {
    private int imageId;
    private String name;
    private int salescount;
    private int time;
    private double distance; //m 根据长度来添加m 或 km
    private int pickup; //起送
    private double delivery; //配送
    private int average; //人均

    public ResultItem(int imageId, String name, int salescount, int time, double distance, int pickup, double delivery, int average) {
        this.imageId = imageId;
        this.name = name;
        this.salescount = salescount;
        this.time = time;
        this.distance = distance;
        this.pickup = pickup;
        this.delivery = delivery;
        this.average = average;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalescount() {
        return salescount;
    }

    public void setSalescount(int salescount) {
        this.salescount = salescount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPickup() {
        return pickup;
    }

    public void setPickup(int pickup) {
        this.pickup = pickup;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }
}
