package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.model.ProductsEntity;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository <ProductsEntity, Long> {
//    @Query(nativeQuery = true, value = "select p from ProductEntity p where p.cost between :min and :max;")
    List<ProductsEntity> findAllByCostBetween(Integer min, Integer max);
}