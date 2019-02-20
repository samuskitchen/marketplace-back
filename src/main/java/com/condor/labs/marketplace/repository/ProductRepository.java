package com.condor.labs.marketplace.repository;

import com.condor.labs.marketplace.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findBy_id(ObjectId _id);

    @Query("{name: {$regex : '?0', $options: 'im'}}")
    Page<Product> getProductByName(String name, Pageable pageable);

    @Query("{name: {$regex : '?0', $options: 'im'}, category: ?1}")
    Page<Product> getProductByNameAndCategory(String name, Integer category, Pageable pageable);

    @Query("{category: ?0}")
    Page<Product> getProductByCategory(Integer category, Pageable pageable);
}
