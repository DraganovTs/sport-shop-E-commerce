package com.sport.shop.products.service;

import com.sport.shop.products.model.dto.ShoppingCartDTO;
import com.sport.shop.products.model.entity.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartService {


    ShoppingCart createCart(ShoppingCartDTO cartDTO);

    Optional<ShoppingCart> getCartById(String id);

    void deleteCartById(String id);


}
