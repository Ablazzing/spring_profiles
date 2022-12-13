package org.example.spring_profiles.controller;

import lombok.AllArgsConstructor;
import org.example.spring_profiles.entity.Product.Product;
import org.example.spring_profiles.service.AntonShopService;
import org.example.spring_profiles.service.PetrShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anton/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Profile("anton")
public class AntonShopController implements ShopController{

    AntonShopService antonShopService;

    @PostMapping("/buy")
    @Override
    public ResponseEntity buy(@RequestBody List<Product> productList) {
        antonShopService.buyProduct(productList);
        return new ResponseEntity("Куплено", HttpStatus.OK);
    }

    @PostMapping("/sell")
    @Override
    public ResponseEntity sell(Integer count) {
        antonShopService.sell(count);
        return new ResponseEntity("Продано", HttpStatus.OK);
    }
}
