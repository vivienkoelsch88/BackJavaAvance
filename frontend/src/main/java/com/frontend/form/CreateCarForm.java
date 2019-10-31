package com.frontend.form;

public class CreateCarForm {
    private int id;
    private int horse_power;
    private String immatriculation;
    private int km_price;
    private String marque;
    private String model;
    private int reservation_price;
    private int previewPrice;

    public CreateCarForm(int id, int horse_power, String immatriculation, int km_price, String marque, String model, int reservation_price, int previewPrice) {
        this.id = id;
        this.horse_power = horse_power;
        this.immatriculation = immatriculation;
        this.km_price = km_price;
        this.marque = marque;
        this.model = model;
        this.reservation_price = reservation_price;
        this.previewPrice = previewPrice;
    }

    public CreateCarForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(int horse_power) {
        this.horse_power = horse_power;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getKm_price() {
        return km_price;
    }

    public void setKm_price(int km_price) {
        this.km_price = km_price;
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

    public int getPreviewPrice() {
        return previewPrice;
    }

    public void setPreviewPrice(int previewPrice) {
        this.previewPrice = previewPrice;
    }

    public void setReservation_price(int reservation_price) {
        this.reservation_price = reservation_price;
    }
}
