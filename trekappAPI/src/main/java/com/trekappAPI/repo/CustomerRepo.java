package com.trekappAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trekappAPI.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {



}
