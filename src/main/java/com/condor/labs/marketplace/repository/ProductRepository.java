package com.condor.labs.marketplace.repository;

import com.condor.labs.marketplace.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findBy_id(ObjectId _id);

    @Query("{name: {$regex : '?0', $options: 'im'}}")
    List<Product> getProductByName(String name);

    @Query("{name: {$regex : '?0', $options: 'im'}, category: ?1}")
    List<Product> getProductByNameAndCategory(String name, Integer category);

    @Query("{category: ?0}")
    List<Product> getProductByCategory(Integer category);
}
