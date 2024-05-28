package com.sport.shop.products.specification;

import com.sport.shop.products.model.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecificationTitleBrandCategory {

    public Specification<Product> getProducts(ProductSpecParams specParams) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Search by title
            if (specParams.getSearch() != null && !specParams.getSearch().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
                        "%" + specParams.getSearch().toLowerCase() + "%"));
            }

            // Filter by category ID
            if (specParams.getCategoryId() != null && specParams.getCategoryId() != 0) {
                predicates.add(criteriaBuilder.equal(root.join("category", JoinType.INNER).get("categoryId"),
                        specParams.getCategoryId()));
            }

            // Filter by brand ID
            if (specParams.getBrandId() != null && specParams.getBrandId() != 0) {
                predicates.add(criteriaBuilder.equal(root.join("brand", JoinType.INNER).get("brandId"),
                        specParams.getBrandId()));
            }

            // Sorting
            if (specParams.getSort() != null && !specParams.getSort().isEmpty()) {
                switch (specParams.getSort()) {
                    case "priceAsc":
                        query.orderBy(criteriaBuilder.asc(root.get("price")));
                        break;
                    case "priceDesc":
                        query.orderBy(criteriaBuilder.desc(root.get("price")));
                        break;
                    default:
                        query.orderBy(criteriaBuilder.asc(root.get("title")));
                        break;
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
