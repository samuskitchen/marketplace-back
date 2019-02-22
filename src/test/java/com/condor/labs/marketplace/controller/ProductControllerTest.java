package com.condor.labs.marketplace.controller;

import com.condor.labs.marketplace.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    MockMvc mockMvc;

    @Autowired
    ProductController productController;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.productController).build();
    }

    @Test
    public void getAllProductByScore() throws Exception {
        Product product = new Product();
        product.setName("Xbox One S");

        this.mockMvc.perform(get("/findall/product-score")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].name", is(product.getName())));
    }

    @Test
    public void getProductByCategory() throws Exception {
        Product product = new Product();
        product.setName("Xbox One S");

        String name = "xbox";
        Integer category = 3;

        // Test to consult by product name
        this.mockMvc.perform(get("/findall/product/category?name=" + name)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(product.getName())));

        // Test to consult products by category
        this.mockMvc.perform(get("/findall/product/category?category=" + category)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(product.getName())));

        // Test to consult by category and product name
        this.mockMvc.perform(get("/findall/product/category?name=" + name +"&category=" + category)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(product.getName())));

    }
}