package com.condor.labs.marketplace.controller;

import com.condor.labs.marketplace.model.Cart;
import com.condor.labs.marketplace.model.dto.CartDetail;
import com.condor.labs.marketplace.model.dto.ProductCartDetail;
import com.condor.labs.marketplace.model.dto.ProductQuantity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CartController cartController;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getDetailCart() throws Exception {
        String id = new ObjectId().toHexString();
        List<ProductCartDetail> productCartDetailList = new ArrayList<>();
        productCartDetailList.add(new ProductCartDetail(new ObjectId(), "", "", new Decimal128(1), 1, "COP"));

        CartDetail cartDetail = new CartDetail(productCartDetailList, 1, new Decimal128(new BigDecimal(1)), new ObjectId(id));
        given(cartController.getDetailCart(id)).willReturn(cartDetail);

        this.mockMvc.perform(get("/detail/cart?idCart=" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)));

    }

    @Test
    public void addCart() throws Exception {
        String id = new ObjectId().toHexString();
        List<ProductQuantity> productQuantityList = new ArrayList<>();
        productQuantityList.add(new ProductQuantity(new ObjectId(), 1));

        Cart cart = new Cart(new ObjectId(id), productQuantityList, new Decimal128(new BigDecimal(1)), 1, LocalDateTime.now());
        given(cartController.addCart(productQuantityList)).willReturn(cart);

        this.mockMvc.perform(post("/add/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productQuantityList)))
                .andExpect(status().isOk());
    }

    @Test
    public void removeProductCart() throws Exception {
        String idCart = new ObjectId().toHexString();
        String idProduct = new ObjectId().toHexString();

        List<ProductQuantity> productQuantityList = new ArrayList<>();
        productQuantityList.add(new ProductQuantity(new ObjectId(idProduct), 1));
        Cart cart = new Cart(new ObjectId(idCart), productQuantityList, new Decimal128(new BigDecimal(1)), 1, LocalDateTime.now());

        given(cartController.removeProductCart(idCart, idProduct)).willReturn(cart);

        this.mockMvc.perform(post("/remove/product-cart?idCart=" + idCart + "&idProduct=" + idProduct)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productQuantityList)))
                .andExpect(status().isOk());

    }
}