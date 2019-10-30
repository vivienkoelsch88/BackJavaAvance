package com.frontend.controllers;

import com.frontend.models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class RentalController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${vacation-service.url}")
    private String vacationUrl;

    @GetMapping("/admin/rentals")
    public String listRentals(Model model) {

        List<Rental> rentals = restTemplate.getForObject(vacationUrl + "/", List.class);
        System.out.println(rentals);

        model.addAttribute("rentals", rentals);

        return "admin/rentalsList";
    }
}
