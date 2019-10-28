package com.rentalsservice.controllers;

import com.rentalsservice.models.Rental;
import com.rentalsservice.repositories.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/rentals")
@RestController
public class RentalsController {

    @Autowired
    private RentalsRepository rentalsRepository;

    @GetMapping("/")
    public List<Rental> listRentals() {

        return rentalsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rental findRental(@PathVariable int id) {

        return rentalsRepository.findById(id);
    }

    @PostMapping("/create")
    public void createRental(@RequestBody Rental rental) {

        rentalsRepository.save(rental);
    }

    @PutMapping("/update")
    public void updateRental(@RequestBody Rental rental) {

        rentalsRepository.save(rental);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRental(@PathVariable int id) {

        rentalsRepository.deleteById(id);
    }

    @GetMapping("/vacant-cars")
    public Object[] getBookedCars(@RequestBody Date[] period) {

        return rentalsRepository.getBookedCarIds(period[0], period[1]);
    }
}
