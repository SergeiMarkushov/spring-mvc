package ru.gb.serveces;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.DTO.ProductDTO;
import ru.gb.exceptions.ResourceNotFoundException;
import ru.gb.model.ProductsEntity;
import ru.gb.repositories.ProductDAO;
import ru.gb.specifications.ProductSpecifications;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    public ProductsEntity save(ProductsEntity product) {
       return productDAO.save(product);
    }

    public Page<ProductsEntity> findAll(Integer minCost, Integer maxCost, String partTitle, Integer page){
        Specification<ProductsEntity> spec = Specification.where(null);
        if (minCost != null) {
            spec = spec.and(ProductSpecifications.costGreaterOrEquals(minCost));
        }
        if (maxCost != null) {
            spec = spec.and(ProductSpecifications.costLessOrEqualsThan(maxCost));
        }
        if (partTitle != null) {
            spec = spec.and(ProductSpecifications.titleLike(partTitle));
        }
        return productDAO.findAll(spec, PageRequest.of(page - 1, 50));
    }
    @Transactional
    public ProductsEntity update(ProductDTO productDTO) {
        ProductsEntity productsEntity = productDAO.findById(productDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Can not update product, not in database"));
        productsEntity.setCost(productDTO.getCost());
        productsEntity.setTitle(productDTO.getTitle());
        return productsEntity;
    }

    public Optional<ProductsEntity> findById(Long id) { return productDAO.findById(id); }
}
