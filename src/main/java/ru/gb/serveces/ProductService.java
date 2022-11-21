package ru.gb.serveces;

import org.springframework.stereotype.Service;
import ru.gb.model.ProductHW;
import ru.gb.repositories.ProductDaoImpl;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDao;


    public ProductService (ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    public List<ProductHW> getAllProducts() {
        return Collections.unmodifiableList(productDao.findAll());
    }

    public void add(ProductHW product) {
        productDao.saveOrUpdate(product);
    }
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

//    public void changeCount(Long productId, Integer delta) {
//        Product product = productDao.findByID(productId);
//        if((product.getCount()+delta)<0) {
//            product.setCount(0);
//        } else {
//            product.setCount(product.getCount() + delta);
//        }
//    }
}
