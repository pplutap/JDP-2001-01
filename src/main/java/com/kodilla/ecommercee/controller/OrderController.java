package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/order")

public class OrderController {


    @Autowired
    private DbService service;
    @Autowired
    private OrderMapper orderMapper;

    //lista wszystkich zamowien
    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(service.getAllOrders());
    }

    //dodanie nowego zamowienia
    @RequestMapping(method = RequestMethod.POST, value = "addOrder", consumes = APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody OrderDto orderDto) {
        service.saveOrder(orderMapper.mapToOrder(orderDto));

    }

    //wyswietlenie pojedynczego zamowienia
    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(service.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    //aktualizcja zamowienia
    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {

        return orderMapper.mapToOrderDto((service.saveOrder(orderMapper.mapToOrder(orderDto))));
    }

    //usuniecie zamowienia
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long orderId) {
        service.deleteOrder(orderId);


    }
}


/*
lista wszystkich zamówień
dodanie nowego zamówienia
wyświetlenie zamówienia
aktualizacja zamówienia
usunięcie zamówienia
 */