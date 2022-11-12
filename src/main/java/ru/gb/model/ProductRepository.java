package ru.gb.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductRepository {
    private static final ProductRepository INSTANCE = new ProductRepository();
    private final List<Product> productList = new ArrayList<>();

//    {
//               productList.add(new Product("Milk", 100.0));
//               productList.add(new Product("Bread", 40.5));
//               productList.add(new Product("Butter", 80.0));
//               productList.add(new Product("Eggs",99.9));
//               productList.add(new Product("Souce",45.5));
//    }

    public List<Product> getProductList() {
        return productList;
    }
}