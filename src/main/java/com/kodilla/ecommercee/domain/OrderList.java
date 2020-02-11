package com.kodilla.ecommercee.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERLIST")
public class OrderList {

    private int id;
    private String listName;
    private String description;
    private List<Order> orders = new ArrayList<>();

    public OrderList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "orderList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public OrderList() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

