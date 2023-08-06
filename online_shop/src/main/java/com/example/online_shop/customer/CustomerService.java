package com.example.online_shop.customer;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCList(){
        List<Customer> cList = customerRepository.findAll();
        return cList;
    }

    public Customer getCustomer(Integer id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public void insertCustomer(String name, Date birthday){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setBirthday(birthday);
        this.customerRepository.save(customer);
    }


}
