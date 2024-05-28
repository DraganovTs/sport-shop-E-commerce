package com.sport.shop.products.service;

import com.sport.shop.products.model.dto.ProductResponseDTO;
import com.sport.shop.products.model.dto.ProductResponseListDTO;
import com.sport.shop.products.specification.ProductSpecParams;
import org.springframework.beans.factory.annotation.Value;

public interface ProductService {



    public ProductResponseDTO getProductById(long id);
    public ProductResponseListDTO getProductList(ProductSpecParams specParams);
}
