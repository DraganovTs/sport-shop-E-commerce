package com.sport.shop.products.service;

import com.sport.shop.products.entity.Brand;
import com.sport.shop.products.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {


    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands(){
      return   brandRepository.findAll();
    }
}