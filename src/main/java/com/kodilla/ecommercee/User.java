package com.kodilla.ecommercee;

import com.kodilla.ecommercee.temp.Cart;
import com.kodilla.ecommercee.temp.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    private long id;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private Cart cart;
    private List<Order> order = new ArrayList<>();

    public User(long id, String name, String surname, String mail, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    @NotNull
    @Column(name = "MAIL")
    public String getMail() {
        return mail;
    }

    @NotNull
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private void setMail(String mail) {
        this.mail = mail;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @OneToMany(targetEntity = Order.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
