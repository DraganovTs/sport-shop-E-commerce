package com.sport.shop.products.exception;

public class ShoppingCartNotFoundException extends RuntimeException{


    public ShoppingCartNotFoundException(String id) {
        super("Shopping cart not found whit id: " + id);
    }
}
