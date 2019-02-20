package com.condor.labs.marketplace.service;

import com.condor.labs.marketplace.model.Product;
import com.condor.labs.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllByScore(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "score");
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable);
    }

    public Page<Product> getProductByName(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.getProductByName(name, pageable);
    }

    public Page<Product> getProductByNameAndCategory(String name, Integer category, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.getProductByNameAndCategory(name, category, pageable);
    }

    public Page<Product> getProductByCategory(Integer category, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.getProductByCategory(category, pageable);
    }
}
