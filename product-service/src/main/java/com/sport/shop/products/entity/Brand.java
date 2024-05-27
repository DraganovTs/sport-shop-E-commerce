package com.sport.shop.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "brand_name")
    private String brandName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Product> products;
}
