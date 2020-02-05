package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/project/products")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return Arrays.asList(new ProductDto(1L, "Something"), new ProductDto(2L, "SomethingElse"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public String getProduct(Long productId) {
        return "getProduct test";
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct")
    public void addProduct(ProductDto productDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public String updateProduct(ProductDto productDto) {
        return "updateProduct test";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Long productId) {

    }
}
