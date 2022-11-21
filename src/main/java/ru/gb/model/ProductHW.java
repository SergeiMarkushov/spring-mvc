package ru.gb.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductHW {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private int cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ProductHW() {
    }

    public ProductHW(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "ProductHW{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }

    public void print() {
        System.out.println("Product id = " + id + "; title = " + title + "; cost = " + cost);
    }
}
