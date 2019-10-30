package com.frontend.controllers;

import com.frontend.form.AddVacanciesCarsRequestBody;
import com.frontend.form.FreeCarsForm;
import com.frontend.models.Cars;
import com.frontend.models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.context.WebContext;

import java.util.Date;
import java.util.List;

@Controller
public class FreeCarsController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${vacation-service.url}")
    private String vacationUrl;

    @GetMapping("/user/freeCarsForm")
    public String freeCarsForm(Model model) {

        model.addAttribute("listCarsForm", new FreeCarsForm());

        return "user/freeCarsForm";
    }

    @PostMapping("/freeCarsList")
    public String freeCarsListe(Model model, FreeCarsForm form) {

        Date[] dates = {form.getDateDebut(), form.getDateFin()};
        AddVacanciesCarsRequestBody request = new AddVacanciesCarsRequestBody(dates, form.getPreviewKm());

        model.addAttribute("dates", dates);

        Cars[] carList = restTemplate.postForEntity("http://localhost:8081/AddVacanciesCars/" + form.getIdUser(), request, Cars[].class).getBody();

        model.addAttribute("carList", carList);

        return "user/freeCarsList";
    }
}
