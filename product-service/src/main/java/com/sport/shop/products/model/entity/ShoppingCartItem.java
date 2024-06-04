package com.sport.shop.products.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShoppingCartItem {

    private long productId;
    private String title;
    private int quantity;
    private String imageUrl;
    private double price;
    private String brandName;
    private String categoryName;
}
