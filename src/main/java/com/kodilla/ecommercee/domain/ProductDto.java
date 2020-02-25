package com.kodilla.ecommercee.domain;

import javax.persistence.Column;
import java.math.BigDecimal;

public class ProductDto {
    private long id;

    private String name;

    private String description;

    private BigDecimal price;
}
