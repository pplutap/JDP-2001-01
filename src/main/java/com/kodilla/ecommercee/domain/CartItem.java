package com.kodilla.ecommercee.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Setter
@Entity
@NoArgsConstructor
public class CartItem {

    @EmbeddedId
    private CartProductId cartProductId;

    @Column
    @NotNull
    private Integer quantity;

    public CartItem(Cart cart, Product product, Integer quantity) {
        cartProductId = new CartProductId();
        cartProductId.setCart(cart);
        cartProductId.setProduct(product);
        this.quantity = quantity;
    }

    @Transient
    public Product getProduct() {
        return this.cartProductId.getProduct();
    }

    @Transient
    public Double getItemPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public CartProductId getCartProductId() {
        return cartProductId;
    }

    public Integer getQuantity() {
        return quantity;
    }


}
