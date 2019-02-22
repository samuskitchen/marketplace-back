package com.condor.labs.marketplace.service;

import com.condor.labs.marketplace.model.Category;
import com.condor.labs.marketplace.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class CategoryServiceTest {

    @MockBean
    CategoryRepository categoryRepository;

    @Test
    public void getAll() {
        List<Category> categoryList = new ArrayList<>();
        Category category = new Category();
        category.setIdCategory(1);
        category.setName("Libros");

        categoryList.add(category);

        //when
        given(categoryRepository.getAll()).willReturn(categoryList);

        //then
        assertThat(categoryList.size()).isEqualTo(1);
        assertThat(categoryList.get(0).getName()).isEqualTo(category.getName());
    }
}