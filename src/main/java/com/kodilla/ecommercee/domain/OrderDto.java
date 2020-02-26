package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfShipment;
    private String shippingAdress;
    private boolean isOrdered;

    public OrderDto(LocalDateTime dateOfCreation, LocalDateTime dateOfShipment, String shippingAdress) {
        this.dateOfCreation = dateOfCreation;
        this.dateOfShipment = dateOfShipment;
        this.shippingAdress = shippingAdress;
    }
}