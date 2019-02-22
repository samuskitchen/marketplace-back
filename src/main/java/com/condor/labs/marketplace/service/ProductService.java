package com.condor.labs.marketplace.service;

import com.condor.labs.marketplace.model.Product;
import com.condor.labs.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllByScore() {
        Sort sort = new Sort(Sort.Direction.DESC, "score");
        return productRepository.findAll(sort);
    }

    public List<Product> getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public List<Product> getProductByNameAndCategory(String name, Integer category) {
        return productRepository.getProductByNameAndCategory(name, category);
    }

    public List<Product> getProductByCategory(Integer category) {
        return productRepository.getProductByCategory(category);
    }
}
