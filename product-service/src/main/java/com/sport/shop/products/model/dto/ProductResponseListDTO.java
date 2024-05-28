package com.sport.shop.products.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductResponseListDTO {

    private int totalPages;
    private long totalCount;
    private int pageIndex;
    private int pageSize;
    private List<ProductResponseDTO> productList;

    public ProductResponseListDTO() {
        this.productList = new ArrayList<>();
    }
}
