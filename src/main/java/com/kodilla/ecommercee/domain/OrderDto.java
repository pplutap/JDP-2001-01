package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {

    private Long id;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfShipment;
    private String shippingAdress;
    private boolean isOrdered;


}