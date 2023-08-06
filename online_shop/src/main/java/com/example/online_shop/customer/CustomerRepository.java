package com.example.online_shop.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAll();

//    Customer findById(Integer Id);

}
