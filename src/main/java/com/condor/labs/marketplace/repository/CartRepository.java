package com.condor.labs.marketplace.repository;

import com.condor.labs.marketplace.model.Cart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    Cart findBy_id(ObjectId _id);

    @Query(value =
            "{ _id: ?0}," +
            "{ $pull: { products: { id: ?1}}}")
    Cart deleteProductById(ObjectId _id, ObjectId idProduct);
}
