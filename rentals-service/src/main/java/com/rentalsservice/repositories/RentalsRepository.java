package com.rentalsservice.repositories;

import com.rentalsservice.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer> {
    Rental findById(int id);

    @Query(value = "SELECT car_id from rental WHERE ?1 < end_date AND ?2 >= start_date",
            nativeQuery = true)
    Object[] getBookedCarIds(Date start, Date end);
}
