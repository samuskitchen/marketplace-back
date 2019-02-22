package com.condor.labs.marketplace.model.dto;

import org.bson.types.ObjectId;

public class ProductQuantity {

    private ObjectId id;
    private Integer quantity;

    public ProductQuantity() {
    }

    public ProductQuantity(ObjectId id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductQuantity{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
