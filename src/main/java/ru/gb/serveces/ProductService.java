package ru.gb.serveces;

import org.springframework.stereotype.Service;
import ru.gb.model.ProductsEntity;
import ru.gb.repositories.ProductDaoImpl;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDao;


    public ProductService(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    public List<ProductsEntity> getAllProducts() {
        return Collections.unmodifiableList(productDao.findAll());
    }

    public void add(ProductsEntity product) {
        productDao.saveOrUpdate(product);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public ProductsEntity getProductInfo(Long id) {
        return productDao.getProductInfo(id);
    }
}
