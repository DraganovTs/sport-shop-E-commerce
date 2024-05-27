package com.sport.shop.products.controller;

import com.sport.shop.products.entity.Brand;
import com.sport.shop.products.entity.Category;
import com.sport.shop.products.entity.Product;
import com.sport.shop.products.service.BrandService;
import com.sport.shop.products.service.CategoryService;
import com.sport.shop.products.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/sport", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    private final CategoryService categoryService;
    private final ProductService productService;

    private final BrandService brandService;

    public ProductController(CategoryService categoryService, ProductService productService, BrandService brandService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.brandService = brandService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> categories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(categories);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> products() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> brands() {
        List<Brand> brands = brandService.getAllBrands();
        if (brands.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(brands);
    }
}
