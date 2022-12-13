package org.example.spring_profiles.service;

import org.example.spring_profiles.entity.Product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AntonShopService implements ShopService{
    private List<Product> products = new ArrayList<>();
    private static final String PRODUCT_NAME = "ORANGE";

    @Override
    public void buyProduct(List<Product> incomeProducts) {
        if (!incomeProducts.stream().allMatch(e -> e.getName().equals(PRODUCT_NAME))) {
            throw new ProductTypeIncorrectException(String.format("Один из продуктов не равен %s", PRODUCT_NAME));
        }
        products.addAll(incomeProducts);
    }

    public void buyProductV2(List<Product> incomeProducts) {
        if (!incomeProducts.stream().allMatch(e -> e.getName().equals(PRODUCT_NAME))) {
            throw new ProductTypeIncorrectException(String.format("Один из продуктов не равен %s", PRODUCT_NAME));
        }
        products.addAll(incomeProducts);
    }

    @Override
    public void sell(Integer count) {
        if (products.size() < count) {
            throw new NoEnoughProductsException(String.format("Нету столько %s", PRODUCT_NAME));
        }
        products = products.stream().skip(count).collect(Collectors.toList());
    }
}
