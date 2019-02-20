package com.condor.labs.marketplace.controller;

import com.condor.labs.marketplace.model.Cart;
import com.condor.labs.marketplace.model.dto.CartDetail;
import com.condor.labs.marketplace.model.dto.ProductQuantity;
import com.condor.labs.marketplace.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    @RequestMapping(value = "detail/cart")
    public CartDetail getDetailCart(@RequestParam(name = "idCart") String idCart) {
        return cartService.getCartById(idCart);
    }

    @PostMapping
    @RequestMapping(value = "add/cart")
    public Cart addCart(@RequestBody List<ProductQuantity> productQuantities) {
        return cartService.saveCart(productQuantities);
    }

    @PostMapping
    @RequestMapping(value = "remove/product-cart")
    public Cart removeProductCart(@RequestParam(name = "idCart") String idCart,
                                  @RequestParam(name = "idProduct") String idProduct) {
        return cartService.deleteProductById(idCart, idProduct);
    }
}
