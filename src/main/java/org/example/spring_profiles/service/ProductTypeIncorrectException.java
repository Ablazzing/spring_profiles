package org.example.spring_profiles.service;

public class ProductTypeIncorrectException extends RuntimeException {
    public ProductTypeIncorrectException() {
    }

    public ProductTypeIncorrectException(String message) {
        super(message);
    }
}
