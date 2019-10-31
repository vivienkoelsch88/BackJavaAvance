package com.frontend.controllers;

import com.frontend.form.InfosCustomer;
import com.frontend.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Controller
public class CustomerController {

@Autowired
private RestTemplate restTemplate;

    @GetMapping("/admin/customer")
    public String goCustomer(Model model){
        model.addAttribute("form", new InfosCustomer());
        return "admin/customer";
    }

    @PostMapping("/admin/customer")
    public String customerSave(Model model, InfosCustomer form){

        Customer customer = new Customer(form.getName(), form.getFirst_name(), form.getBirthday(), form.getDate_license(), form.getNumber_license());
        System.out.println(customer.getName());
        restTemplate.postForObject("http://localhost:8083/saveClient", customer, Customer.class);
        model.addAttribute("form", new InfosCustomer());
        return "admin/customer";
    }
}
