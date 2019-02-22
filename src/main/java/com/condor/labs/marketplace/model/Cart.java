package com.condor.labs.marketplace.model;

import com.condor.labs.marketplace.model.dto.ProductQuantity;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Cart {

    @Id
    private ObjectId _id;
    private List<ProductQuantity> products;
    private Decimal128 totalMount;
    private Integer quantity;
    private LocalDateTime dateCart;

    public Cart() {
    }

    public Cart(ObjectId _id, List<ProductQuantity> products, Decimal128 totalMount, Integer quantity, LocalDateTime dateCart) {
        this._id = _id;
        this.products = products;
        this.totalMount = totalMount;
        this.quantity = quantity;
        this.dateCart = dateCart;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public List<ProductQuantity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductQuantity> products) {
        this.products = products;
    }

    public BigDecimal getTotalMount() {
        return totalMount.bigDecimalValue();
    }

    public void setTotalMount(Decimal128 totalMount) {
        this.totalMount = totalMount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateCart() {
        return dateCart;
    }

    public void setDateCart(LocalDateTime dateCart) {
        this.dateCart = dateCart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + _id +
                ", products=" + products +
                ", totalMount=" + totalMount +
                ", quantity=" + quantity +
                ", dateCart=" + dateCart +
                '}';
    }
}
