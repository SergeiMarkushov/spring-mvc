package ru.gb.model;


import lombok.Data;

@Data
public class Product {
    private  Long id;
    private String title;
    private Double cost;
    private static Long idProduct = 1L;

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
        this.id = idProduct;
        idProduct += 1L;
    }

    public static Long getIdProduct() {
        return idProduct;
    }
}