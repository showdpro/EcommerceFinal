package com.example.android.ecommerce;

public class UserInfoForDatabase {

    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String email;
    private String website;
    private String instagram;
    private String facebook;
    private String linkedIn;
    private String designation;
    private String worktype;
    private String picUri;

    public UserInfoForDatabase() {
    }

    public UserInfoForDatabase(String name, String phone, String address, String city, String state, String email, String website, String instagram, String facebook, String linkedIn, String designation, String worktype,String picUri) {

        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.website = website;
        this.instagram = instagram;
        this.facebook = facebook;
        this.linkedIn = linkedIn;
        this.designation = designation;
        this.worktype = worktype;
        this.picUri=picUri;
    }

    public String getPicUri() {
        return picUri;
    }

    public void setPicUri(String picUri) {
        this.picUri = picUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }
}
