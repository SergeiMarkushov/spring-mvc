package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gb.model.ProductsEntity;

@Repository
public interface ProductDAO extends JpaRepository <ProductsEntity, Long>, JpaSpecificationExecutor<ProductsEntity> {

}