package com.condor.labs.marketplace.service;

import com.condor.labs.marketplace.model.Cart;
import com.condor.labs.marketplace.model.dto.ProductQuantity;
import com.condor.labs.marketplace.repository.CartRepository;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class CartServiceTest {

    private String id;
    private List<ProductQuantity> productQuantityList;
    private Cart cart;

    @MockBean
    CartRepository cartRepository;

    @Before
    public void setUp() throws Exception {
        id = new ObjectId().toHexString();

        productQuantityList = new ArrayList<>();
        productQuantityList.add(new ProductQuantity(new ObjectId(), 1));

        cart = new Cart(new ObjectId(id), productQuantityList, new Decimal128(new BigDecimal(1)), 1, LocalDateTime.now());
    }

    @Test
    public void saveCart() {
        //when
        given(cartRepository.save(cart)).willReturn(cart);
        given(cartRepository.findBy_id(new ObjectId(id))).willReturn(cart);

        //then
        assertThat(cart.get_id(), is(CoreMatchers.equalTo(id)));
        assertThat(cartRepository.findBy_id(new ObjectId(id)).get_id(), is(CoreMatchers.equalTo(id)));
    }

    @Test
    public void getCartById() {
        //when
        given(cartRepository.findBy_id(new ObjectId(id))).willReturn(cart);

        //then
        assertThat(cart.get_id(), is(CoreMatchers.equalTo(id)));
        assertThat(cartRepository.findBy_id(new ObjectId(id)).get_id(), is(CoreMatchers.equalTo(id)));
    }

    @Test
    public void deleteProductById() {
        //when
        cart.setProducts(productQuantityList);
        given(cartRepository.save(cart)).willReturn(cart);
        given(cartRepository.findBy_id(new ObjectId(id))).willReturn(cart);

        //then
        assertThat(cart.get_id(), is(CoreMatchers.equalTo(id)));
        assertThat(cartRepository.findBy_id(new ObjectId(id)).getProducts().get(0).getId(), is(CoreMatchers.equalTo(productQuantityList.get(0).getId())));
    }
}