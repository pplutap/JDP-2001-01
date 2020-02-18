package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_name")
    private String name;

    @ManyToMany(
            targetEntity = Order.class,
            mappedBy = "orders",
            fetch = FetchType.LAZY
    )


    private List<Order> orders;


}

