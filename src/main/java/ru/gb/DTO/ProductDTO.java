package ru.gb.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.model.ProductsEntity;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private Integer cost;

    public ProductDTO(ProductsEntity product){
        this.title = product.getTitle();
        this.id = product.getId();
        this.cost = product.getCost();
    }
}
