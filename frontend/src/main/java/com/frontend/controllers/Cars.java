package com.frontend.controllers;

import com.frontend.form.AddVacanciesCarsRequestBody;
import com.frontend.form.FreeCarsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

public class Cars {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/freeCarsForm")
    public String freeCarsForm(Model model) {

        model.addAttribute("listCarsForm", new FreeCarsForm());

        return "user/freeCarsForm";
    }

//    @PostMapping("/freeCarsList")
//    public String freeCarsListe(Model model, FreeCarsForm form) {
//
//        Date[] dates = {form.getDateDebut(), form.getDateFin()};
//        AddVacanciesCarsRequestBody request = new AddVacanciesCarsRequestBody(dates, form.getPreviewKm());
//
//        com.frontend.models.Cars[] carList = restTemplate.postForEntity("http://localhost:8081/AddVacanciesCars/" + form.getIdUser(), request, com.frontend.models.Cars[].class).getBody();
//
//        model.addAttribute("carList", carList);
//
//        return "user/freeCarsList";
//    }
}
