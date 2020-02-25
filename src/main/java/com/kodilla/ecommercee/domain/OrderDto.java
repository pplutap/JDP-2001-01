package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfShipment;
    private String shippingAdress;
    private boolean isOrdered;
    private Long userId;

}