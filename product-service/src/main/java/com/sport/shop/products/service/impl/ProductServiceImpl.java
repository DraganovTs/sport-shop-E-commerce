package com.sport.shop.products.service.impl;

import com.sport.shop.products.mapper.ProductMapper;
import com.sport.shop.products.model.dto.ProductResponseDTO;
import com.sport.shop.products.model.dto.ProductResponseListDTO;
import com.sport.shop.products.model.entity.Product;
import com.sport.shop.products.repository.ProductRepository;
import com.sport.shop.products.service.ProductService;
import com.sport.shop.products.specification.ProductSpecParams;
import com.sport.shop.products.specification.ProductSpecificationTitleBrandCategory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Value("${pagination.page.size.default}")
    private Integer defaultPageSize;

    private final ProductRepository productRepository;
    private final ProductSpecificationTitleBrandCategory productSpecification;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductSpecificationTitleBrandCategory productSpecification,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productSpecification = productSpecification;
        this.productMapper = productMapper;
    }


    @Override
    public ProductResponseDTO getProductById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(productMapper::ProductToProductResponseDTO).orElse(null);
    }

    @Override
    public ProductResponseListDTO getProductList(ProductSpecParams specParams) {

        List<Product> productsList;
        Page<Product> pages;

        if (specParams.getPageIndex() == null || specParams.getPageIndex() == 0) {
            productsList = productRepository.findAll(productSpecification.getProducts(specParams));
            if (productsList != null && !productsList.isEmpty()) {
                ProductResponseListDTO productResponseListDTO = new ProductResponseListDTO();
                productResponseListDTO.setTotalCount(productsList.size());
                productResponseListDTO.setProductList(new ArrayList<>());
                for (Product product : productsList) {
                    ProductResponseDTO productResponseDTO = productMapper.ProductToProductResponseDTO(product);
                    productResponseListDTO.getProductList().add(productResponseDTO);
                }
                return productResponseListDTO;
            }
        } else {
            if (specParams.getPageSize() == null || specParams.getPageSize() == 0) {
                specParams.setPageSize(defaultPageSize);
            }
            Pageable paging = PageRequest.of(specParams.getPageIndex() - 1, specParams.getPageSize());
            pages = productRepository.findAll(productSpecification.getProducts(specParams), paging);
            if (pages != null && pages.hasContent()) {
                productsList = pages.getContent();
                ProductResponseListDTO productResponseListDTO = new ProductResponseListDTO();
                productResponseListDTO.setTotalPages(pages.getTotalPages());
                productResponseListDTO.setTotalCount(pages.getTotalElements());
                productResponseListDTO.setPageIndex(specParams.getPageIndex());
                productResponseListDTO.setPageSize(specParams.getPageSize());
                productResponseListDTO.setProductList(new ArrayList<>());
                for (Product product : productsList) {
                    ProductResponseDTO productResponseDTO = productMapper.ProductToProductResponseDTO(product);
                    productResponseListDTO.getProductList().add(productResponseDTO);
                }
                return productResponseListDTO;
            }
        }
        return null;

    }
}
