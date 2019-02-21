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

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart saveCart(List<ProductQuantity> products) {

        final BigDecimal[] totalMount = {BigDecimal.valueOf(0)};
        final Integer[] totalQuantity = {0};

        //We obtain the values of the total shopping cart value and total product
        getValuesCart(products, totalMount, totalQuantity);

        Cart cart = new Cart();
        cart.setProducts(products);
        cart.setQuantity(totalQuantity[0]);
        cart.setTotalMount(new Decimal128(totalMount[0]));
        cart.setDateCart(LocalDateTime.now());
        return cartRepository.save(cart);
    }

    public CartDetail getCartById(String _id) {
        CartDetail cartDetail = new CartDetail();
        Cart cartOption = cartRepository.findBy_id(new ObjectId(_id));

        if (null != cartOption) {
            List<ProductCartDetail> products = new ArrayList<>();

            //We go through the products to assemble the structure of the cart detail
            cartOption.getProducts().forEach(productQuantity -> {
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
            });

            cartDetail.setId(new ObjectId(cartOption.get_id()));
            cartDetail.setProducts(products);
            cartDetail.setQuantityCart(cartOption.getQuantity());
            cartDetail.setTotalMount(new Decimal128(cartOption.getTotalMount()));

            return cartDetail;
        } else {
            return cartDetail;
        }
    }

    public Cart deleteProductById(String idCart, String idProduct) {
        Cart cartOption = cartRepository.findBy_id(new ObjectId(idCart));

        if (null != cartOption){

            //We filter the product list, to obtain the product to be removed from the cart
            ProductQuantity productQuantity = cartOption.getProducts()
                    .stream()
                    .filter(productQuantity1 -> productQuantity1.getId().equals(idProduct))
                    .findFirst()
                    .orElse(null);

            //We remove the product from the cart's product list
            cartOption.getProducts().remove(productQuantity);

            final BigDecimal[] totalMount = {BigDecimal.valueOf(0)};
            final Integer[] totalQuantity = {0};

            //We update the total values of purchase value and total products
            getValuesCart(cartOption.getProducts(), totalMount, totalQuantity);
            cartOption.setTotalMount(new Decimal128(totalMount[0]));
            cartOption.setQuantity(totalQuantity[0]);

            //We update the cart
            return cartRepository.save(cartOption);
        }

        return new Cart();
    }

    private void getValuesCart(List<ProductQuantity> products, BigDecimal[] totalMount, Integer[] totalQuantity) {
        products.forEach(productQuantity -> {
            Product product = productRepository.findBy_id(new ObjectId(productQuantity.getId()));

            if (null != product) {
                totalMount[0] = totalMount[0].add(product.getPrice());
                totalQuantity[0] += productQuantity.getQuantity();
            }
        });
    }
}