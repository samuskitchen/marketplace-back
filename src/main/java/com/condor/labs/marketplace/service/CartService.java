package com.condor.labs.marketplace.service;

import com.condor.labs.marketplace.model.Cart;
import com.condor.labs.marketplace.model.Product;
import com.condor.labs.marketplace.model.dto.CartDetail;
import com.condor.labs.marketplace.model.dto.ProductCartDetail;
import com.condor.labs.marketplace.model.dto.ProductQuantity;
import com.condor.labs.marketplace.repository.CartRepository;
import com.condor.labs.marketplace.repository.ProductRepository;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart saveCart(List<ProductQuantity> products) {

        BigDecimal totalMount = BigDecimal.valueOf(0);
        Integer totalQuantity = 0;

        for (ProductQuantity productQuantity : products) {
            Optional<Product> product = productRepository.findById(productQuantity.getId());

            if (product.isPresent()) {
                totalMount.add(product.get().getPrice());
                totalQuantity += product.get().getQuantity();
            }
        }

        Cart cart = new Cart();
        cart.setProducts(products);
        cart.setQuantity(totalQuantity);
        cart.setTotalMount(new Decimal128(totalMount));
        cart.setDateCart(LocalDateTime.now());
        return cartRepository.save(cart);
    }

    public CartDetail getCartById(String _id) {
        CartDetail cartDetail = new CartDetail();
        Cart cartOption = cartRepository.findBy_id(new ObjectId(_id));

        if (null != cartOption) {
            List<ProductCartDetail> products = new ArrayList<>();

            for (ProductQuantity productQuantity : cartOption.getProducts()) {
                Product optionalProduct = productRepository.findBy_id(new ObjectId(productQuantity.getId()));

                if (null != optionalProduct) {
                    ProductCartDetail productCartDetail = new ProductCartDetail();
                    productCartDetail.set_id(new ObjectId(optionalProduct.getId()));
                    productCartDetail.setCurrencyProduct(optionalProduct.getCurrency());
                    productCartDetail.setImageProduct(optionalProduct.getImage());
                    productCartDetail.setNameProduct(optionalProduct.getName());
                    productCartDetail.setQuantityProduct(productQuantity.getQuantity());
                    productCartDetail.setPriceProduct(new Decimal128(optionalProduct.getPrice()));

                    products.add(productCartDetail);
                }
            }

            cartDetail.setProducts(products);
            cartDetail.setQuantityCart(cartOption.getQuantity());
            cartDetail.setTotalMount(new Decimal128(cartOption.getTotalMount()));

            return cartDetail;
        } else {
            return cartDetail;
        }
    }

    public Cart deleteProductById(String idCart, String idProduct) {
        ObjectId _id = new ObjectId(idCart);
        ObjectId objectIdProduct = new ObjectId(idProduct);
        return cartRepository.deleteProductById(_id, objectIdProduct);
    }
}