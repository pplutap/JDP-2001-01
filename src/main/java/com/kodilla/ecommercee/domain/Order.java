package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "DATE_OF_CREATION")
    private LocalDateTime dateOfCreation;

    @NotNull
    @Column(name = "DATE_OF_SHIPMENT")
    private LocalDateTime dateOfShipment;

    @NotNull
    @Column(name = "SHIPPING_ADRESS")
    private String shippingAdress;

    @NotNull
    @Column(name = "STATUS")
    private boolean isOrdered;


    @ManyToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "ordered_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products=new ArrayList<>();


    public Order(LocalDateTime dateOfCreation, LocalDateTime dateOfShipment, String shippingAdress) {
        this.dateOfCreation = dateOfCreation;
        this. dateOfShipment = dateOfShipment;
        this.shippingAdress = shippingAdress;
    }
}


