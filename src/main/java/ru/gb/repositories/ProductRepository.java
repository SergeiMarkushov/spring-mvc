package ru.gb.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Repository
public class ProductRepository {
    private List<Product> productList;
        @PostConstruct
        public void init() {
            productList = new ArrayList<>(List.of(
                new Product(1L,"Молоко", 100.0, 0),
                new Product(2L,"Хлеб", 89.0, 0),
                new Product(3L,"Масло", 80.0,0),
                new Product(4L,"Яйца", 110.0,0)
            ));
        }



    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public void add(Product product) {
        productList.add(product);
    }

    public Product findByID(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst().get();
    }

    public void deleteById(Long id) {
            productList.removeIf(product -> product.getId().equals(id));
    }
}