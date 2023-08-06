package com.example.online_shop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public void insertProduct(String p_name,Integer price){
        Product product = new Product();
        product.setP_name(p_name);
        product.setPrice(price);
        this.productRepository.save(product);
    }
}
