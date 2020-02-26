package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto mapToOrderDto(final Order order){
        return new OrderDto(
                order.getDateOfCreation(),
                order.getDateOfShipment(),
                order.getShippingAdress()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList){
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
