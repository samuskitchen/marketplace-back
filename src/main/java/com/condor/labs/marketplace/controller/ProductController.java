package com.condor.labs.marketplace.controller;

import com.condor.labs.marketplace.model.Product;
import com.condor.labs.marketplace.service.ProductService;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    @RequestMapping(value = "findall/product-score")
    public Page<Product> getAllProductByScore(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                              @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        return productService.getAllByScore(page, size);
    }

    @GetMapping
    @RequestMapping(value = "findall/product/category")
    public Page<Product> getProductByCategory(@RequestParam(name = "name", required = false) String name,
                                              @RequestParam(name = "category", required = false) Integer category,
                                              @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                              @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {

        if (!StringHelper.isNullOrEmptyString(name) && null == category) {
            return productService.getProductByName(name, page, size);
        } else if (null != category && StringHelper.isNullOrEmptyString(name)) {
            return productService.getProductByCategory(category, page, size);
        } else {
            return productService.getProductByNameAndCategory(name, category, page, size);
        }
    }
}
