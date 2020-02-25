package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(final Long id) {
        return Optional.ofNullable(productRepository.findById(id).orElseThrow(ProductNotFoundException::new));
    }

    public void deleteProduct(final Long id) throws ProductNotFoundException {
        try {
            productRepository.deleteById(id);
        } catch(ProductNotFoundException e) {
            throw new ProductNotFoundException("Product with id " + id + " does not exist", e);
        }
    }
}
