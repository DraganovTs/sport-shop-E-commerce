package com.sport.shop.products.specification;

import lombok.Data;

@Data
public class ProductSpecParams {

    private Integer pageSize;
    private Integer pageIndex;
    private String search;
    private String sort;
    private Long brandId;
    private Long categoryId;
    private final int maxPageSize = 20;

    public void setPageSize(int pageSize) {
        if (pageSize > maxPageSize) {
            this.pageSize = maxPageSize;
        }
        this.pageSize = pageSize;
    }

    public void setSearch(String search) {
        this.search = search.toLowerCase();
    }

}
