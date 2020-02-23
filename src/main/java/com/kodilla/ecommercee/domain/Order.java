package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@AllArgsConstructor
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


    @OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "productId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products=new ArrayList<>();

}


