package com.sport.shop.products.init;

import com.sport.shop.products.model.entity.Brand;
import com.sport.shop.products.model.entity.Category;
import com.sport.shop.products.model.entity.Product;
import com.sport.shop.products.repository.BrandRepository;
import com.sport.shop.products.repository.CategoryRepository;
import com.sport.shop.products.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbInitData {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;


    @PostConstruct
    public void startApp() {
        if (brandRepository.count() == 0) {
            initBrands();
        }
        if (categoryRepository.count() == 0) {
            initCategories();
        }
        if (productRepository.count() == 0) {
            initProducts();
        }
    }

    private void initCategories() {
        var category01 = Category.builder()
                .categoryName("Shoes")
                .build();
        var category02 = Category.builder()
                .categoryName("Hats")
                .build();
        var category03 = Category.builder()
                .categoryName("Jacket")
                .build();
        List<Category> categories = new ArrayList<>();
        categories.add(category01);
        categories.add(category02);
        categories.add(category03);
        categoryRepository.saveAll(categories);
    }

    private void initBrands() {
        var brand01 = Brand.builder()
                .brandName("Nike")
                .build();
        var brand02 = Brand.builder()
                .brandName("Adidas")
                .build();
        var brand03 = Brand.builder()
                .brandName("Lotto")
                .build();
        List<Brand> brands = new ArrayList<>();
        brands.add(brand01);
        brands.add(brand02);
        brands.add(brand03);
        brandRepository.saveAll(brands);
    }

    private void initProducts() {
        List<Product> products = new ArrayList<>();

        var product1 = Product.builder()
                .sku("TestSKU")
                .description("good for outdoor activities")
                .price(23.44)
                .title("Snikers")
                .imageUrl("htt[://test.test")
                .isActive(true)
                .unitsInStock(3)
                .category(categoryRepository.findById(1L).get())
                .brand(brandRepository.findById(1L).get())
                .build();

        var product2 = Product.builder()
                .sku("TestSKU2")
                .description("good for indoor activities")
                .price(55.23)
                .title("Shoker")
                .imageUrl("htt[://test2.test2")
                .isActive(true)
                .unitsInStock(31)
                .category(categoryRepository.findById(2L).get())
                .brand(brandRepository.findById(2L).get())
                .build();

        var product3 = Product.builder()
                .sku("TestSKU3")
                .description("good for all activities")
                .price(23.44)
                .title("Smok")
                .imageUrl("htt[://test3.test3")
                .isActive(true)
                .unitsInStock(2)
                .category(categoryRepository.findById(3L).get())
                .brand(brandRepository.findById(3L).get())
                .build();

        var product4 = Product.builder()
                .sku("TestSKU4")
                .description("good 4 outdoor activities")
                .price(64.84)
                .title("BadHat")
                .imageUrl("htt[://test4.test4")
                .isActive(true)
                .unitsInStock(33)
                .category(categoryRepository.findById(1L).get())
                .brand(brandRepository.findById(3L).get())
                .build();

        var product5 = Product.builder()
                .sku("TestSKU5")
                .description("good for indoor activities")
                .price(55.23)
                .title("Shoee")
                .imageUrl("htt[://test5.test5")
                .isActive(true)
                .unitsInStock(11)
                .category(categoryRepository.findById(2L).get())
                .brand(brandRepository.findById(1L).get())
                .build();

        var product6 = Product.builder()
                .sku("TestSKU6")
                .description("good for all activities")
                .price(66.66)
                .title("Speek")
                .imageUrl("htt[://test6.test6")
                .isActive(true)
                .unitsInStock(1)
                .category(categoryRepository.findById(3L).get())
                .brand(brandRepository.findById(1L).get())
                .build();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);

        productRepository.saveAll(products);
    }
}
