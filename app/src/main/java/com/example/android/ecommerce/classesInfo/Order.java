package com.example.android.ecommerce.classesInfo;

public class Order {

    private String order_name, order_brand, order_date, order_time;
    private double order_price;
    //button is left

    public Order() {
    }

    public Order(String order_name, String order_brand, String order_date, String order_time, double order_price) {
        this.order_name = order_name;
        this.order_brand = order_brand;
        this.order_date = order_date;
        this.order_time = order_time;
        this.order_price = order_price;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_brand() {
        return order_brand;
    }

    public void setOrder_brand(String order_brand) {
        this.order_brand = order_brand;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }
}
