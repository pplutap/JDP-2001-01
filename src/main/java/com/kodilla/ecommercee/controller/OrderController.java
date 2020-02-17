package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/v1/project/order")


public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return Arrays.asList(new OrderDto(1L, "Order_one"),new OrderDto(2L,"Order_two"),new OrderDto(3L,"Order_three"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder( @RequestParam Long orderId) throws OrderNotFoundException{
        return new OrderDto(1L,"Order_One");
    }

    @RequestMapping(method = RequestMethod.POST, value = "addOrder")
    public OrderDto addOrder(OrderDto orderDto) {
        return new OrderDto(4L, "Order Added");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(Long orderId) {
       return new OrderDto(2L,"Updated");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {

    }
}


