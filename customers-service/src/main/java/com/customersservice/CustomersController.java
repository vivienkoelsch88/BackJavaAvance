package com.customersservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomersController {
    @Autowired
    private CustomerDao CustomerDao;

    @RequestMapping(value="/client", method= RequestMethod.GET)
    public @ResponseBody
    Iterable<Customers> client() {
        return CustomerDao.findAll();
    }

    @GetMapping(value="/client/{id}")
    public Customers afficherUnClient(@PathVariable int id){
        return CustomerDao.findById(id);
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public void creerUnClient(@RequestBody Customers customer){
        CustomerDao.save(customer);
    }

    @RequestMapping(value = "/updateClient/{id}", method = RequestMethod.POST)
    public void modifierUnClient(@RequestBody Customers customer, @PathVariable int id){
    if (null!=CustomerDao.findById(id)){
        CustomerDao.save(customer);
    }
    }

    @GetMapping(value="/deleteClient/{id}")
    public void supprimerUnClient(@PathVariable int id){
        CustomerDao.deleteById(id);
    }
}
