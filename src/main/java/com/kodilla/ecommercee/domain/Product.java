package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Cart> carts = new ArrayList<>();

    public Product(String name, String description, BigDecimal price, Group group) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.group = group;
    }

}

