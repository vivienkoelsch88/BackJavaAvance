package com.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/admin/customer")
    public String goCustomer(Model model){
        return "admin/customer";
    }
}
