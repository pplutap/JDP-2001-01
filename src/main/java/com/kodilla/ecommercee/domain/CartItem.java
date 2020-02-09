package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem that = (CartItem) o;

        if (!Objects.equals(cartProductId, that.cartProductId))
            return false;
        return Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        int result = cartProductId != null ? cartProductId.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
