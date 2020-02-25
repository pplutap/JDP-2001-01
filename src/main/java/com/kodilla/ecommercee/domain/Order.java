package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    public Order(LocalDateTime dateOfCreation, LocalDateTime dateOfShipment, String shippingAdress, Boolean isOrdered) {
        this.dateOfCreation = dateOfCreation;
        this.dateOfShipment = dateOfShipment;
        this.shippingAdress = shippingAdress;
        this.isOrdered = isOrdered;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ORDER_ID")
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


    @OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany
    @JoinTable(
            name="JOIN_PRODUCT_ORDER",
            joinColumns = {@JoinColumn(name="ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    private List<Product> products=new ArrayList<>();

}


