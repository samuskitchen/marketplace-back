package com.condor.labs.marketplace.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Category {

    @Id
    private ObjectId id;

    @Indexed
    private Integer idCategory;

    private String name;
    private Boolean activate;

    public Category() {
    }

    public Category(ObjectId id, Integer idCategory, String name, Boolean activate) {
        this.id = id;
        this.idCategory = idCategory;
        this.name = name;
        this.activate = activate;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }
}
