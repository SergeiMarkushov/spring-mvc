package ru.gb.serveces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.DTO.ProductDTO;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItem {

    private ProductDTO product;
    private Integer quantity;

    public LineItem(long productId) {
        this.product = new ProductDTO();
        this.product.setId(productId);
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return product.getId().equals(lineItem.product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(product.getId());
    }
}
