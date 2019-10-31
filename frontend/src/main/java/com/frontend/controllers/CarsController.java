package com.frontend.controllers;

import com.frontend.form.AddVacanciesCarsRequestBody;
import com.frontend.form.CreateCarForm;
import com.frontend.form.FreeCarsForm;
import com.frontend.models.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Controller
public class CarsController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/createCarsForm")
    public String createCarsForm(Model model) {

        model.addAttribute("form", new CreateCarForm());

        return "admin/CreateCar";
    }

    @PostMapping("/createCarsForm")
    public String createCarsListe(Model model, CreateCarForm form) {

        Cars car = new Cars(form.getImmatriculation(), form.getMarque(), form.getModel(), form.getReservation_price(), form.getKm_price(), form.getHorse_power());

        restTemplate.postForObject("http://localhost:8082/cars", car, void.class);

        model.addAttribute("form", new CreateCarForm());

        return "admin/CreateCar";
    }
}
