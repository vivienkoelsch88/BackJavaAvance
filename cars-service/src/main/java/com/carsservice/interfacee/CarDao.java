package com.carsservice.interfacee;

import com.carsservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
     Car findById(int id);
     void deleteById(int id);


}
