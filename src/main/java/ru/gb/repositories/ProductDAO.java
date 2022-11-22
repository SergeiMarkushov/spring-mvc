package ru.gb.repositories;

import ru.gb.model.ProductsEntity;

import java.util.List;

public interface ProductDAO {
    ProductsEntity findById(Long id);

    List<ProductsEntity> findAll();

    ProductsEntity findByTitle(String title);

    void deleteById(Long id);

    ProductsEntity saveOrUpdate(ProductsEntity product);

    ProductsEntity productInfo(Long id);
}
