package com.vacanciesservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AddVacanciesCarsRequestBody {
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] datesBody;
    private int previewKm;

    public AddVacanciesCarsRequestBody() {
    }

    public Date[] getDatesBody() {
        return datesBody;
    }

    public void setDatesBody(Date[] datesBody) {
        this.datesBody = datesBody;
    }

    public int getPreviewKm() {
        return previewKm;
    }

    public void setPreviewKm(int previewKm) {
        this.previewKm = previewKm;
    }
}
