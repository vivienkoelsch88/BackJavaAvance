package com.carsservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;
    private String immatriculation;
    private String marque;
    private String model;
    private int reservation_price;
    private int km_price;
    private int horse_power;

    public Car(){

    }

    public Car(String immatriculation, String marque, String model, int reservation_price, int km_price, int horse_power) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.model = model;
        this.reservation_price = reservation_price;
        this.km_price = km_price;
        this.horse_power = horse_power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReservation_price() {
        return reservation_price;
    }

    public void setReservation_price(int reservation_price) {
        this.reservation_price = reservation_price;
    }

    public int getKm_price() {
        return km_price;
    }

    public void setKm_price(int km_price) {
        this.km_price = km_price;
    }

    public int getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(int horse_power) {
        this.horse_power = horse_power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", immatriculation='" + immatriculation + '\'' +
                ", marque='" + marque + '\'' +
                ", model='" + model + '\'' +
                ", reservation_price=" + reservation_price +
                ", km_price=" + km_price +
                ", horse_power=" + horse_power +
                '}';
    }
}
