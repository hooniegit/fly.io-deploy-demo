package com.example.online_shop.customer;


import com.example.online_shop.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

//import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    private Date birthday;

    @ManyToMany
    private List<Product> productList;
}
