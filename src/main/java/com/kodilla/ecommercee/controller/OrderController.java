package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/v1/project/order", consumes = MediaType.APPLICATION_JSON_VALUE)


public class OrderController {


    @Autowired
    private DbService service;


    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return Arrays.asList(new OrderDto(1L, "Order_one"),new OrderDto(2L,"Order_two"),new OrderDto(3L,"Order_three"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public Order getOrder(@RequestParam Long orderId) throws OrderNotFoundException{
        return service.getOrder(1L).orElseThrow(OrderNotFoundException::new);
    }


    @RequestMapping(method = RequestMethod.POST, value = "addOrder")
    public OrderDto addOrder(OrderDto orderDto) {
        return new OrderDto(4L, "Order_four");
    }



    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(Long orderId) {
       return new OrderDto(2L,"Updated");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        service.deleteOrder(orderId);


    }
}


