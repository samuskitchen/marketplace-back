package com.condor.labs.marketplace.model.dto;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class ProductCartDetail {

    private ObjectId _id;
    private String nameProduct;
    private String imageProduct;
    private Decimal128 priceProduct;
    private Integer quantityProduct;
    private String currencyProduct;

    public ProductCartDetail() {
    }

    public ProductCartDetail(ObjectId _id, String nameProduct, String imageProduct, Decimal128 priceProduct, Integer quantityProduct, String currencyProduct) {
        this._id = _id;
        this.nameProduct = nameProduct;
        this.imageProduct = imageProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.currencyProduct = currencyProduct;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public BigDecimal getPriceProduct() {
        return priceProduct.bigDecimalValue();
    }

    public void setPriceProduct(Decimal128 priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getCurrencyProduct() {
        return currencyProduct;
    }

    public void setCurrencyProduct(String currencyProduct) {
        this.currencyProduct = currencyProduct;
    }
}
