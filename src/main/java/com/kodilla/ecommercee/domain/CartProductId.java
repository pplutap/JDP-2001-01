package com.kodilla.ecommercee.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class CartProductId implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartProductId that = (CartProductId) o;

        if (!cart.equals(that.cart)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = cart.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }
}
