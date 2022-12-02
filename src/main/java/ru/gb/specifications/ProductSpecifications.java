package ru.gb.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.model.ProductsEntity;

public class ProductSpecifications {
    public static Specification<ProductsEntity> costGreaterOrEquals(Integer cost){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"),cost);
    }
    public static Specification<ProductsEntity> costLessOrEqualsThan(Integer cost){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"),cost);
    }
    public static Specification<ProductsEntity> titleLike(String namePart){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),String.format("%%%s%%",namePart));
    }
}
