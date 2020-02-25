package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.OrderNotFoundException;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/project/order",consumes = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderDbService service;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(service.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder( @RequestParam Long orderId) {
        return orderMapper.mapToOrderDto(service.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addOrder")
    public  void addOrder( OrderDto orderDto) {
//        service.saveOrder(orderMapper.mapToOrder(orderDto));
        //todo: wymaga poprawy - dodanie nowego zamowienia wymaga też uwzglednienia produktów które będą w tym zamówieniu
        // aktualnie nie ma jeszcze zrobionej encji pod produkty wiec trzeba będzie wrócic do tego
    }


    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
//        return orderMapper.mapToOrderDto(service.saveOrder(orderMapper.mapToOrder(orderDto)));
        //todo: wymaga poprawy - aktualizacja zamowienia musi aktualizować też dane o produktach, a ich jak jeszcze nie ma

        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        service.deleteOrder(orderId);
    }
}
