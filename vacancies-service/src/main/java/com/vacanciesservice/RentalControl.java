package com.vacanciesservice;

import com.vacanciesservice.model.AddVacanciesCarsRequestBody;
import com.vacanciesservice.model.Cars;
import com.vacanciesservice.model.Customers;
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

    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/AddVacanciesCars/{idClient}")
    public Cars[] AddVacanciesCars(@RequestBody AddVacanciesCarsRequestBody requestBoby, @PathVariable int idClient) {

        Date[] datesBody = requestBoby.getDatesBody();
        int previewKm = requestBoby.getPreviewKm();

        ArrayList<Cars> VacanciesCars = new ArrayList<>();
        Cars[] ResponseCars =  restTemplate.getForEntity("http://localhost:8082/carList", Cars[].class).getBody();

        HttpEntity<Date[]> entity = new HttpEntity<Date[]>(datesBody);

        int[] ResponseIdNoVacanciesCars = restTemplate.postForEntity("http://localhost:8084/rentals/vacant-cars", entity, int[].class).getBody();

        Customers customers = restTemplate.getForEntity("http://localhost:8083/client/" + idClient, Customers.class).getBody();
        int CustomerAge = getYears(customers.getBirth_date());

        if(CustomerAge < 18){
            return null;
        } else if(CustomerAge < 21){
            for (Cars car : ResponseCars) {
                if(car.getHorse_power() < 8) {
                    car.setPreviewPrice(previewKm * car.getKm_price() + car.getReservation_price());
                    VacanciesCars.add(car);
                }
                for (int id : ResponseIdNoVacanciesCars){
                    if(id == car.getId()) {
                        VacanciesCars.remove(car);
                    }
                }
            }
        }else if(CustomerAge < 25){
            for (Cars car : ResponseCars) {
                if(car.getHorse_power() < 13) {
                    car.setPreviewPrice(previewKm * car.getKm_price() + car.getReservation_price());
                    VacanciesCars.add(car);
                }
                for (int id : ResponseIdNoVacanciesCars){
                    if(id == car.getId()) {
                        VacanciesCars.remove(car);
                    }
                }
            }
        } else {
            for (Cars car : ResponseCars) {
                car.setPreviewPrice(previewKm * car.getKm_price() + car.getReservation_price());
                VacanciesCars.add(car);
                for (int id : ResponseIdNoVacanciesCars){
                    if(id == car.getId()) {
                        VacanciesCars.remove(car);
                    }
                }
            }
        }
        Cars[] carsForReturn = new Cars[VacanciesCars.size()];
        return VacanciesCars.toArray(carsForReturn);

    }

    public static int getYears(Date d)
    {
        Calendar curr = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(d);
        int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        curr.add(Calendar.YEAR,-yeardiff);
        if(birth.after(curr))
        {
            yeardiff = yeardiff - 1;
        }
        return yeardiff;
    }

}
