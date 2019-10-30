package com.frontend.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FreeCarsForm {

    private int idUser;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateDebut;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateFin;
    private int previewKm;

    public FreeCarsForm() {
    }

    public FreeCarsForm(int idUser, Date dateDebut, Date dateFin, int previewKm) {
        this.idUser = idUser;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.previewKm = previewKm;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getPreviewKm() {
        return previewKm;
    }

    public void setPreviewKm(int previewKm) {
        this.previewKm = previewKm;
    }
}
