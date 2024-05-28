package com.sport.shop.products.mapper;

import com.sport.shop.products.model.dto.ProductResponseDTO;
import com.sport.shop.products.model.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public ProductResponseDTO ProductToProductResponseDTO(Product product){
        return  ProductResponseDTO.builder()
                .productId(product.getProductId())
                .categoryId(product.getCategory().getCategoryId())
                .brandId(product.getBrand().getBrandId())
                .categoryName(product.getCategory().getCategoryName())
                .brandName(product.getBrand().getBrandName())
                .price(product.getPrice())
                .title(product.getTitle())
                .imageUrl(product.getImageUrl())
                .description(product.getDescription())
                .sku(product.getSku())
                .build();
    }
}
