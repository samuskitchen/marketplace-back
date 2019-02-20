package com.condor.labs.marketplace.model.dto;

import org.bson.types.Decimal128;

import java.math.BigDecimal;
import java.util.List;

public class CartDetail {

    private List<ProductCartDetail> products;
    private Integer quantityCart;
    private Decimal128 totalMount;

    public CartDetail() {
    }

    public CartDetail(List<ProductCartDetail> products, Integer quantityCart, Decimal128 totalMount) {
        this.products = products;
        this.quantityCart = quantityCart;
        this.totalMount = totalMount;
    }

    public List<ProductCartDetail> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCartDetail> products) {
        this.products = products;
    }

    public Integer getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(Integer quantityCart) {
        this.quantityCart = quantityCart;
    }

    public BigDecimal getTotalMount() {
        return totalMount.bigDecimalValue();
    }

    public void setTotalMount(Decimal128 totalMount) {
        this.totalMount = totalMount;
    }
}
