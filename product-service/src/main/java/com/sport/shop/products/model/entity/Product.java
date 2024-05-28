package com.sport.shop.products.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "sku")
    private String sku;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "units_in_stock")
    private int unitsInStock;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

}
