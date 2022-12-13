package org.example.spring_profiles.service;

import org.example.spring_profiles.entity.Product.Product;

import java.util.List;

public interface ShopService {
    void buyProduct(List<Product> products);
     void sell(Integer count);
}
