package com.rentalsservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rental {

    @Id
    @GeneratedValue
    private int id;

    private int customerId;
    private int carId;
    private Date startDate;
    private Date endDate;
    private double totalPrice;

    public Rental() {}

    public Rental(int customerId, int carId, Date startDate, Date endDate, double totalPrice) {
        this.customerId = customerId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
