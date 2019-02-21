package com.condor.labs.marketplace.repository;

import com.condor.labs.marketplace.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{activate: true}")
    List<Category> getAll();
}
