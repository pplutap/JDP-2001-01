package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private long id;

    @Column(name = "username")
    private String username;

//    @Column(name = "SURNAME")
//    private String surname;

//    @NotNull
//    @Column(name = "MAIL")
//    private String mail;
//
//    @NotNull
//    @Column(name = "PASSWORD")
//    private String password;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked = false;

    @Column(name = "TOKEN")
    private String token;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @OneToMany(targetEntity = Order.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public User(String surname) {
        this.username = surname;
    }

}


