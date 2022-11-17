package ru.gb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private Double cost;
    private Integer count;
    private String description;

    public Product(Long id, String title, Double cost, Integer count) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.count = count;
    }
}