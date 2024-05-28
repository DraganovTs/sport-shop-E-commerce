package com.sport.shop.products.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Product> products;
}
