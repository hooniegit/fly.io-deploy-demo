package com.example.online_shop.product;

import com.example.online_shop.customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String p_name;

    @Column(length = 10)
    private Integer price;

    private LocalDateTime registration_date;

    @ManyToMany
    private List<Customer> customerList;

}
