package com.condor.labs.marketplace.model;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Map;

@Document
public class Product {

    @Id
    private ObjectId _id;

    @Indexed
    private Integer category;

    private String name;
    private String currency;
    private Decimal128 price;
    private Integer quantity;
    private Decimal128 score;
    private String description;
    private String image;
    private Map<String, String> detail;

    public Product() {
    }

    public Product(ObjectId _id, Integer category, String name, String currency, Decimal128 price, Integer quantity, Decimal128 score, String description, String image, Map<String, String> detail) {
        this._id = _id;
        this.category = category;
        this.name = name;
        this.currency = currency;
        this.price = price;
        this.quantity = quantity;
        this.score = score;
        this.description = description;
        this.image = image;
        this.detail = detail;
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price.bigDecimalValue();
    }

    public void setPrice(Decimal128 price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getScore() {
        return score.bigDecimalValue();
    }

    public void setScore(Decimal128 score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Map<String, String> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, String> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Product{" +
                " id=" + _id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", score=" + score +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", detail=" + detail +
                '}';
    }
}
