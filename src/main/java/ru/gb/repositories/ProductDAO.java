package ru.gb.repositories;

import ru.gb.model.ProductHW;

import java.util.List;

public interface ProductDAO {
    ProductHW findById(Long id);
    List<ProductHW> findAll();
    ProductHW findByTitle(String title);
    void deleteById(Long id);
    ProductHW saveOrUpdate(ProductHW productHW);
}
