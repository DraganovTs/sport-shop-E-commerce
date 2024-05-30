package com.sport.shop.products.controller;

import com.sport.shop.products.model.dto.ProductResponseDTO;
import com.sport.shop.products.model.dto.ProductResponseListDTO;
import com.sport.shop.products.model.entity.Brand;
import com.sport.shop.products.model.entity.Category;
import com.sport.shop.products.service.BrandService;
import com.sport.shop.products.service.CategoryService;
import com.sport.shop.products.service.impl.ProductServiceImpl;
import com.sport.shop.products.specification.ProductSpecParams;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/sport/shop", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    private final CategoryService categoryService;
    private final ProductServiceImpl productService;

    private final BrandService brandService;

    public ProductController(CategoryService categoryService, ProductServiceImpl productServiceImpl, BrandService brandService) {
        this.categoryService = categoryService;
        this.productService = productServiceImpl;
        this.brandService = brandService;
    }

    @GetMapping("/products")
    public ResponseEntity<ProductResponseListDTO> getProducts(ProductSpecParams specParams) {

        ProductResponseListDTO productList = productService.getProductList(specParams);
        return ResponseEntity
                .ok(productList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable long id) {

        ProductResponseDTO responseDTO = productService.getProductById(id);
        return ResponseEntity
                .ok(responseDTO);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> categories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(categories);
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
