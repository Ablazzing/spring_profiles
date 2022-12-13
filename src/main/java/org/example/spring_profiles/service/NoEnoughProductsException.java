package org.example.spring_profiles.service;

public class NoEnoughProductsException extends RuntimeException {
    public NoEnoughProductsException() {
    }

    public NoEnoughProductsException(String message) {
        super(message);
    }
}
