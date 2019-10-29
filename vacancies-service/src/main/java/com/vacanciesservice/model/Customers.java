package com.vacanciesservice.model;

import java.util.Date;

public class Customers {
    private int id;
    private String name;
    private String first_name;
    private Date birth_date;
    private Date date_driver_s_license;
    private int number_driver_s_license;

    public Customers(){
    }

    public Customers (String name, String first_name, Date birth_date, Date date_driver_s_license, int number_driver_s_license){
        this.name = name;
        this.first_name = first_name;
        this.birth_date = birth_date;
        this.date_driver_s_license = date_driver_s_license;
        this.number_driver_s_license = number_driver_s_license;
    }

    public Customers (int id, String name, String first_name, Date birth_date, Date date_driver_s_license, int number_driver_s_license){
        this.id = id;
        this.name = name;
        this.first_name = first_name;
        this.birth_date = birth_date;
        this.date_driver_s_license = date_driver_s_license;
        this.number_driver_s_license = number_driver_s_license;
    }

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getDate_driver_s_license() {
        return date_driver_s_license;
    }

    public void setDate_driver_s_license(Date date_driver_s_license) {
        this.date_driver_s_license = date_driver_s_license;
    }

    public int getNumber_driver_s_license() {
        return number_driver_s_license;
    }

    public void setNumber_driver_s_license(int number_driver_s_license) {
        this.number_driver_s_license = number_driver_s_license;
    }
}
