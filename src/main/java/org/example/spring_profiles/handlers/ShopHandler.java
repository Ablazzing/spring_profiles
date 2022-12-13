package org.example.spring_profiles.handlers;

import org.example.spring_profiles.controller.PetrShopControllerV1;
import org.example.spring_profiles.service.NoEnoughProductsException;
import org.example.spring_profiles.service.ProductTypeIncorrectException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = {PetrShopControllerV1.class})
@Profile("petr")
public class ShopHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoEnoughProductsException.class, ProductTypeIncorrectException.class})
    public ResponseEntity handle(Exception e) {
        return new ResponseEntity("Магазин Петра:" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
