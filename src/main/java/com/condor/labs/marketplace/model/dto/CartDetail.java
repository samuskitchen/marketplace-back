package com.condor.labs.marketplace.model.dto;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.List;

public class CartDetail {

    private List<ProductCartDetail> products;
    private Integer quantityCart;
    private Decimal128 totalMount;
    private ObjectId id;

    public CartDetail() {
    }

    public CartDetail(List<ProductCartDetail> products, Integer quantityCart, Decimal128 totalMount, ObjectId id) {
        this.products = products;
        this.quantityCart = quantityCart;
        this.totalMount = totalMount;
        this.id = id;
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

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "products=" + products +
                ", quantityCart=" + quantityCart +
                ", totalMount=" + totalMount +
                ", id=" + id +
                '}';
    }
}
