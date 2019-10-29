package com.customersservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customers, Integer> {
    Customers findById(int id);
}