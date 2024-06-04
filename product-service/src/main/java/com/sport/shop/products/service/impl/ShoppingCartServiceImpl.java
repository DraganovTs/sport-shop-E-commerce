package com.sport.shop.products.service.impl;

import com.sport.shop.products.model.dto.ShoppingCartDTO;
import com.sport.shop.products.model.entity.ShoppingCart;
import com.sport.shop.products.repository.ShoppingCartRepository;
import com.sport.shop.products.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart createCart(ShoppingCartDTO cartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart(cartDTO.getId());
        shoppingCart.setItems(cartDTO.getItems());
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Optional<ShoppingCart> getCartById(String id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public void deleteBasketById(String id) {
        shoppingCartRepository.deleteById(id);
    }
}
