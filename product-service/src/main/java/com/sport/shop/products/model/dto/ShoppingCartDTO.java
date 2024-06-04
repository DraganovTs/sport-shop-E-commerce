package com.sport.shop.products.model.dto;

import com.sport.shop.products.model.entity.ShoppingCartItem;
import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartDTO {
    private String id;
    private List<ShoppingCartItem> items;

    public ShoppingCartDTO() {

    }
}
