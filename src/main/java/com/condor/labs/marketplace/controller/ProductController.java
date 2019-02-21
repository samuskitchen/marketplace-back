package com.condor.labs.marketplace.controller;

import com.condor.labs.marketplace.model.Product;
import com.condor.labs.marketplace.service.ProductService;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping(value = "findall/product-score")
    public List<Product> getAllProductByScore() {
        return productService.getAllByScore();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping(value = "findall/product/category")
    public List<Product> getProductByCategory(@RequestParam(name = "name", required = false) String name,
                                              @RequestParam(name = "category", required = false) Integer category) {

        if (!StringHelper.isNullOrEmptyString(name) && null == category) {
            return productService.getProductByName(name);
        } else if (null != category && StringHelper.isNullOrEmptyString(name)) {
            return productService.getProductByCategory(category);
        } else {
            return productService.getProductByNameAndCategory(name, category);
        }
    }
}
