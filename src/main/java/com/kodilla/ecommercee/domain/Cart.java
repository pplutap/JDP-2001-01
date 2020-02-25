package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "cartProductId.cart",
            fetch = FetchType.LAZY)
    private Set<CartItem> cartItems = new HashSet<>();

    @Transient
    public BigDecimal getTotalPrice() {
        return  getCartItems().stream()
                .map(CartItem::getItemPrice)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    @Transient
    public int getNumberOfProducts() {
        return  getCartItems().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

}
