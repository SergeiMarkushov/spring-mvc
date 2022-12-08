package ru.gb.serveces;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.gb.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Cart {
    private List<ProductDTO> products = new ArrayList<>();

    public void delete(Long id) {
        List<ProductDTO> productsForIter = new ArrayList<>();
        for (ProductDTO productDTO : productsForIter) {
            if(productDTO.getId().equals(id)) {
                products.remove(productDTO);
            }
        }
    }

    public void addProduct(ProductDTO productDTO) {
        products.add(productDTO);
    }

    public List<ProductDTO> getProductList() {
        return products;
    }
}
