package com.sport.shop.products.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity {



    @Column(name = "date_created", updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "last_updated", insertable = false)
    private LocalDateTime lastUpdated;
}
