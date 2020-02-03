package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public Order mapToOrder(final OrderDto orderDto){
        return new Order(
                orderDto.getId(),
                orderDto.getName());

    }

    public OrderDto mapToOrderDto(final Order order){
        return new OrderDto(
                order.getId(),
                order.getName());


    }

    public List<OrderDto>mapToOrderDtoList(final List<Order> orderList){
        return orderList.stream()
                .map(t->new OrderDto(t.getId(),t.getName()))
                .collect(Collectors.toList());
    }
}
