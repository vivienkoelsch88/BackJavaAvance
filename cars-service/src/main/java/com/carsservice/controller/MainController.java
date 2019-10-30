package com.carsservice.controller;

import com.carsservice.interfacee.CarDao;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.carsservice.model.Car;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CarDao carDao;


    @RequestMapping(value = {"/carList"}, method = RequestMethod.GET)
    public List<Car> carList() {
        return carDao.findAll();  //return to template html o the same name i cant use .html
    }

    @GetMapping(value = "carList/{id}")
    public Car showListByID(@PathVariable int id) {
        return carDao.findById(id);
    }

    @ApiOperation(value = "register a new car")
    @PostMapping(value = "/list")
    public Car save(@RequestBody Car car) {
        return carDao.save(car);
    }


    @PostMapping(value = "/cars")
    public ResponseEntity<Void>addCar(@RequestBody Car car){
        Car car1 = carDao.save(car);
        if (car ==null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(car1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/carsDelete/{id}")
    public void delete(@PathVariable int id) {
         carDao.deleteById(id);
    }

    @PutMapping(value = "/carsUpdate")
    public Car update(@RequestBody Car car) {
        Car car1 = carDao.save(car);
        return car1;
    }
}
