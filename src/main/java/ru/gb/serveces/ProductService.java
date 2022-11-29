package ru.gb.serveces;

import org.springframework.stereotype.Service;
import ru.gb.model.ProductsEntity;
import ru.gb.repositories.ProductDAO;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    public ProductService (ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<ProductsEntity> getAllProducts() {
        return productDAO.findAll();
    }

    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    public ProductsEntity save(ProductsEntity product) {
       return productDAO.save(product);
    }

    public List<ProductsEntity> findAllByCostBetween(int min, int max) {
        return productDAO.findAllByCostBetween(min,max);
    }

}
