package com.condor.labs.marketplace.service;

import com.condor.labs.marketplace.model.Product;
import com.condor.labs.marketplace.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class ProductServiceTest {

    public static final String NAME = "Xbox One S";

    private Product product;
    private List<Product> productList;
    private String name;
    private Integer category;

    @MockBean
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        name = "xbox";
        category = 3;

        product = new Product();
        product.setName(NAME);
        product.setCategory(3);

        productList = new ArrayList<>();
        productList.add(product);
    }

    @Test
    public void getAllByScore() {
        //when
        Sort sort = new Sort(Sort.Direction.DESC, "score");
        given(productRepository.findAll(sort)).willReturn(productList);

        //then
        assertThat(productList.size()).isEqualTo(1);
        assertThat(productList.get(0).getName()).isEqualTo(product.getName());
    }

    @Test
    public void getProductByName() {
        //when
        given(productRepository.getProductByName(name)).willReturn(productList);

        //then
        assertThat(productList.size()).isEqualTo(1);
        assertThat(productList.get(0).getName()).isEqualTo(NAME);

    }

    @Test
    public void getProductByNameAndCategory() {
        //when
        given(productRepository.getProductByNameAndCategory(name, category)).willReturn(productList);

        //then
        assertThat(productList.size()).isEqualTo(1);
        assertThat(productList.get(0).getCategory()).isEqualTo(category);
        assertThat(productList.get(0).getName()).isEqualTo(NAME);
    }

    @Test
    public void getProductByCategory() {
        //when
        given(productRepository.getProductByCategory(category)).willReturn(productList);

        //then
        assertThat(productList.size()).isEqualTo(1);
        assertThat(productList.get(0).getCategory()).isEqualTo(category);
        assertThat(productList.get(0).getName()).isEqualTo(NAME);
    }
}