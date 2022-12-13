package org.example.spring_profiles.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_profiles.entity.Product.Product;
import org.example.spring_profiles.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/petr/v2")
@Profile("petr")
@Slf4j
public class PetrShopControllerV2 implements ShopController {
    ShopService shopService;
    @Value("${shop.thx}")
    private String thx;

    @Autowired
    public PetrShopControllerV2(@Qualifier("petrShopService") ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/buy")
    @Override
    public ResponseEntity buy(@RequestBody List<Product> productList) {
        log.info("Пошли от меня все");
        shopService.buyProduct(productList);
        return new ResponseEntity("Куплено", HttpStatus.OK);
    }

    @PostMapping("/sell")
    @Override
    public ResponseEntity sell(Integer count) {
        shopService.sell(count);
        return new ResponseEntity("Продано", HttpStatus.OK);
    }
}
