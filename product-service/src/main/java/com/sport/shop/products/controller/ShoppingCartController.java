package com.sport.shop.products.controller;

import com.sport.shop.products.model.dto.ShoppingCartDTO;
import com.sport.shop.products.model.entity.ShoppingCart;
import com.sport.shop.products.service.impl.ShoppingCartServiceImpl;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<ShoppingCart> createCart(@Valid @RequestBody ShoppingCartDTO cartDTO) {
        ShoppingCart cart = shoppingCartService.createCart(cartDTO);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable String id) {
        return shoppingCartService.getCartById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable String id) {
        if (shoppingCartService.getCartById(id).isPresent()) {
            shoppingCartService.deleteCartById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
