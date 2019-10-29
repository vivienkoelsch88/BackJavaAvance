package com.vacanciesservice;

import com.vacanciesservice.model.Cars;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RentalControl {

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/AddVacanciesCars")
    public void AddVacanciesCars(@RequestBody Date[] datesBody) {

        ArrayList<Cars> VacanciesCars = new ArrayList<>();

        System.out.println(datesBody[0]);
        System.out.println(datesBody[1]);
        System.out.println(datesBody);
        System.out.println(datesBody.getClass());
//        HttpHeaders entete = new HttpHeaders();
//        entete.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, Date[]> map = new LinkedMultiValueMap<>();
//        map.add("period", datesBody);
//
//        HttpEntity<MultiValueMap<String, Date[]>> requeteHttp = new HttpEntity<MultiValueMap<String, Date[]>>(map, entete);
//        System.out.println(restTemplate.getForObject("http://localhost:8084/rentals/vacant-cars", int[].class, datesBody));

        int[] ResponseIdNoVacanciesCars = restTemplate.getForEntity("http://localhost:8084/rentals/vacant-cars", int[].class, datesBody);

//        Cars[] ResponseCars =  restTemplate.getForEntity("http://localhost:8082/", Cars[].class).getBody();
//
//        for (Cars car : ResponseCars) {
//            if(ResponseIdNoVacanciesCars.toString().contains(car.getId() + "")){
//                VacanciesCars.add(car);
//            }
//        }
    }


}
