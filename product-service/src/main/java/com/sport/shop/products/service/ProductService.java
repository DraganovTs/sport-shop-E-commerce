package com.sport.shop.products.service;

import com.sport.shop.products.entity.Product;
import com.sport.shop.products.repository.ProductRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            Hibernate.initialize(p.getCategory());
            Hibernate.initialize(p.getCategory().getProducts());
            Hibernate.initialize(p.getBrand());
            Hibernate.initialize(p.getBrand().getProducts());
        });
        return products;
    }
}
