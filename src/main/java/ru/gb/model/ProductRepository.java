package ru.gb.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Data
@Component
public class ProductRepository {
    private static final ProductRepository INStANCE = new ProductRepository();
    private final List<Product> productList = new ArrayList<>();

    {
               productList.add(new Product(1L,"Milk", 100.0));
               productList.add(new Product(2L,"Bread", 40.5));
               productList.add(new Product(3L,"Butter", 80.0));
               productList.add(new Product(4L,"Eggs",99.9));
               productList.add(new Product(5L, "Souce",45.5));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public void add(Product product) {
        productList.add(product);
    }
}