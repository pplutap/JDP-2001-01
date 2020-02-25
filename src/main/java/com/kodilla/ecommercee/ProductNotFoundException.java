package com.kodilla.ecommercee;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
