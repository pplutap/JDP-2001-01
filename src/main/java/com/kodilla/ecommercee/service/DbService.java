package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }


    public Order saveOrder(final Order order) {
        return repository.save(order);

    }

    public Optional<Order> getOrder(final Long id) {
        return repository.findById(id);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);

    }

}
