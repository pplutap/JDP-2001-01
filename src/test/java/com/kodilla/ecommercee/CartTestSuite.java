package com.kodilla.ecommercee;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartItemRepository;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemRepository cartDetailsRepository;
    @Test
    public void testTaskDaoSaveWithFinancialDetails() {
        //Given
        Cart cart = new Cart();
        User user=new User("maja");
        Product product=new Product("product",12.3);
        Product product2=new Product("product2",12.00);
        CartItem cartDetails=new CartItem(cart,product,3);
        CartItem cartDetails2=new CartItem(cart,product2,3);
        //When
        cart.setUser(user);
        userRepository.save(user);
        productRepository.save(product);
        cartRepository.save(cart);
        cartDetailsRepository.save(cartDetails);
        cart.setCartItems(Stream.of(cartDetails,cartDetails2).collect(Collectors.toSet()));
        System.out.println(cart.getTotalPrice());

        //CleanUp
        //taskDao.deleteById(id);
    }
}
