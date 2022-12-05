package ru.gb.convertors;

import org.springframework.stereotype.Component;
import ru.gb.DTO.ProductDTO;
import ru.gb.model.ProductsEntity;

@Component
public class ProductConvertor {

    public ProductsEntity dtoToEntity(ProductDTO productDTO) {
        return new ProductsEntity(productDTO.getId(), productDTO.getTitle(), productDTO.getCost());
    }

    public ProductDTO entityToDTO(ProductsEntity product) {
        return new ProductDTO (product.getId(), product.getTitle(), product.getCost());
    }

}
