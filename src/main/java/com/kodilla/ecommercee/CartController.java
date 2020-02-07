package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/project/carts")
public class CartController {
    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return Arrays.asList(new ProductDto(1L, "product1"), new ProductDto(2L, "product2"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct")
    public void addProduct(ProductDto productDto) {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(ProductDto productDto) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(CartDto cartDto) {
    }
}
