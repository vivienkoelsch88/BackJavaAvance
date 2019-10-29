package com.vacanciesservice.model;

import java.util.Date;

public class AddVacanciesCarsRequestBody {
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
