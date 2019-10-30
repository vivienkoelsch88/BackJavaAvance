package com.frontend.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class InfosCustomer {
    private String name;
    private String first_name;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String email;
    private String passeword;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_license;

    private int number_license;

    public InfosCustomer() {
    }

    public InfosCustomer(String name, String first_name, Date birthday, String email, String passeword, String adress, String adress2, String city, String state, String zip, Date date_license, int number_license) {
        this.name = name;
        this.first_name = first_name;
        this.birthday = birthday;
        this.email = email;
        this.passeword = passeword;
        this.address = adress;
        this.address2 = adress2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.date_license = date_license;
        this.number_license = number_license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getDate_license() {
        return date_license;
    }

    public void setDate_license(Date date_license) {
        this.date_license = date_license;
    }

    public int getNumber_license() {
        return number_license;
    }

    public void setNumber_license(int number_license) {
        this.number_license = number_license;
    }
}
