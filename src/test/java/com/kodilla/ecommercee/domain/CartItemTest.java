package com.kodilla.ecommercee.domain;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartItemTest {

    @Autowired
    Cart cart;
    int quantity = 3;
    @Test
    public void getItemPrice() {
        //Given
        Product product = new Product();
        product.setPrice(new BigDecimal("2"));
        CartItem cartItem = new CartItem(cart, product, quantity);
        //When
        BigDecimal value = cartItem.getItemPrice();
        //Then
        Assert.assertEquals(new BigDecimal("6"), value);
    }
}