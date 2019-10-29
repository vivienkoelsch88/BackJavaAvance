package com.vacanciesservice;

import com.vacanciesservice.model.Cars;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class RentalControl {

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/AddVacanciesCars")
    public int[] AddVacanciesCars(@RequestBody Date[] datesBody) {

        ArrayList<Cars> VacanciesCars = new ArrayList<>();

        HttpEntity<Date[]> entity = new HttpEntity<Date[]>(datesBody);

        int[] ResponseIdNoVacanciesCars = restTemplate.postForEntity("http://localhost:8084/rentals/vacant-cars", entity, int[].class).getBody();

        return ResponseIdNoVacanciesCars;
//        Cars[] ResponseCars =  restTemplate.getForEntity("http://localhost:8082/", Cars[].class).getBody();
//
//        for (Cars car : ResponseCars) {
//            if(ResponseIdNoVacanciesCars.toString().contains(car.getId() + "")){
//                VacanciesCars.add(car);
//            }
//        }
    }


}
