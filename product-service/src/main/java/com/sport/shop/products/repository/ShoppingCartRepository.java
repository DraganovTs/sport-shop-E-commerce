package com.sport.shop.products.repository;

import com.sport.shop.products.model.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,String > {
}
