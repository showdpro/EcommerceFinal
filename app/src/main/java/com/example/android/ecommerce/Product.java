package com.example.android.ecommerce;

public class Product {

    private String prod_name, prod_brand, buy_button;
    private int image;
    private double prod_price;

    public Product() {
    }

    public Product(String prod_name, String prod_brand, Double prod_price, String buy_button, int image) {
        this.prod_name = prod_name;
        this.prod_brand = prod_brand;
        this.prod_price = prod_price;
        this.buy_button = buy_button;
        this.image = image;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_brand() {
        return prod_brand;
    }

    public void setProd_brand(String prod_brand) {
        this.prod_brand = prod_brand;
    }

    public double getProd_price() {
        return prod_price;
    }

    public void setProd_price(Double prod_price) {
        this.prod_price = prod_price;
    }

    public String getBuy_button() {
        return buy_button;
    }

    public void setBuy_button(String buy_button) {
        this.buy_button = buy_button;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
