package com.sport.shop.products.controller;

import com.sport.shop.products.model.dto.ShoppingCartDTO;
import com.sport.shop.products.model.entity.ShoppingCart;
import com.sport.shop.products.service.impl.ShoppingCartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ShoppingCartServiceImpl shoppingCartService;

    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping()
    public ResponseEntity<ShoppingCart> createCart(@RequestBody ShoppingCartDTO cartDTO) {
        ShoppingCart cart = shoppingCartService.createCart(cartDTO);
        return ResponseEntity.ok(cart);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable String id) {
        Optional<ShoppingCart> optionalCart = shoppingCartService.getCartById(id);
        if (optionalCart.isPresent()) {
            return ResponseEntity.ok(optionalCart.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable String id) {
        Optional<ShoppingCart> optionalCart = shoppingCartService.getCartById(id);
        if (optionalCart.isPresent()) {
            shoppingCartService.deleteBasketById(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }


}
