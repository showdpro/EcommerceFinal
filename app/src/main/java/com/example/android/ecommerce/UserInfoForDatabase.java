package com.example.android.ecommerce;

public class UserInfoForDatabase {

    private String name;
    private String phone;
    private String address;
    private String email;
    private String website;
    private String designation;
    private String worktype;

    public UserInfoForDatabase() {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.website = website;
        this.designation = designation;
        this.worktype = worktype;
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
