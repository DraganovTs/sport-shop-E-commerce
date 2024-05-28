package com.sport.shop.products.model.dto;

import com.sport.shop.products.model.entity.Brand;
import com.sport.shop.products.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {
    private Long productId;
    private double price;
    private Long brandId;
    private Long categoryId;
    private String title;
    private String sku;
    private String description;
    private String categoryName;
    private String brandName;
    private String imageUrl;


}
