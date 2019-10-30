package com.frontend.controllers;

import com.frontend.forms.RentalForm;
import com.frontend.models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Controller
public class RentalController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rentals-service.url}")
    private String rentalsUrl;

    @GetMapping("/admin/rentals")
    public String listRentals(Model model) {

        List<Rental> rentals = restTemplate.getForObject(rentalsUrl + "/", List.class);

        model.addAttribute("rentals", rentals);

        return "admin/rentalsList";
    }

    @GetMapping("/admin/createRental")
    public String addRental(Model model) {

        RentalForm rentalForm = new RentalForm();
        model.addAttribute("rentalForm", rentalForm);

        return "admin/createRental";
    }

    @PostMapping("/admin/createRental")
    public String saveRental(Model model,
                             @ModelAttribute("rentalForm") RentalForm rentalForm) {

        int customerId = rentalForm.getCustomerId();
        int carId = rentalForm.getCarId();
        Date startDate = rentalForm.getStartDate();
        Date endDate = rentalForm.getEndDate();

        if (customerId > 0 &&
            carId > 0 &&
            startDate.getTime() > new Date().getTime() &&
            endDate.getTime() > startDate.getTime()) {

            restTemplate.postForObject(rentalsUrl + "/create", new Rental(customerId, carId, startDate, endDate), Rental.class);

            return "redirect:/admin/rentals";
        }

        return "admin/createRental";
    }

    @GetMapping("/admin/rentals/delete/{id}")
    public String deleteRental(Model model,
                               @PathVariable int id) {

        restTemplate.delete(rentalsUrl + "/delete/" + id);

        return "redirect:/admin/rentals";
    }
}
