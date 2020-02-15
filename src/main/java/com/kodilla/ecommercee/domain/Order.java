package com.kodilla.ecommercee.domain;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_name")
    private String name;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "order",
            fetch = FetchType.LAZY
    )
    private List<Order> orders;


}
