package ru.gb.serveces;

import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repositories.ProductRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;


    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productRepository.getAllProducts());
    }

    public void add(Product product) {
        productRepository.add(product);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeCount(Long productId, Integer delta) {
        Product product = productRepository.findByID(productId);
        product.setCount(product.getCount() + delta);
    }
}
