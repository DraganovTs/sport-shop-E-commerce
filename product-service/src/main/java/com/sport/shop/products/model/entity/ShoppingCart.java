package com.sport.shop.products.model.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@RedisHash("SHOPPINGCART")
@Data
public class ShoppingCart {

    private String id;
    private List<ShoppingCartItem> items;

    public ShoppingCart(String id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    public ShoppingCart() {
    }
}
