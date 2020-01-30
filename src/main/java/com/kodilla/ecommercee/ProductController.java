package com.kodilla.ecommercee;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public List<String> getProducts() {
        return new ArrayList<>();
    }

    public String getProduct(Long productId) {
        return "getProduct test";
    }

    public void addProduct(String productDto) {

    }

    public String updateProduct(String productDto) {
        return "updateProduct test";
    }

    public void deleteProduct(Long productId) {

    }
}
