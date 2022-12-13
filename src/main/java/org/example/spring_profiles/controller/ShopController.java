package org.example.spring_profiles.controller;

import org.example.spring_profiles.entity.Product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ShopController {

     ResponseEntity buy(List<Product> productList);
     ResponseEntity sell(Integer count);
}
