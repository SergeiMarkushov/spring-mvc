package ru.gb.serveces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.DTO.ProductDTO;
import ru.gb.model.ProductsEntity;
import ru.gb.repositories.ProductDAO;
import ru.gb.specifications.ProductSpecifications;

@Service
public class ProductService {
    private ProductDAO productDAO;

    public ProductService (ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    public ProductsEntity save(ProductsEntity product) {
       return productDAO.save(product);
    }

    public ProductsEntity getProductById(Long id) {
        return productDAO.getReferenceById(id);
    }

    public Page<ProductsEntity> find(Integer minCost, Integer maxCost, String partTitle, Integer page){
        Specification<ProductsEntity> spec = Specification.where(null);
        // select p from ProductEntity p where true
        if (minCost != null) {
            spec = spec.and(ProductSpecifications.costGreaterOrEquals(minCost));
            //select p from ProductEntity p where true and p.price > minPrice
        }
        if (maxCost != null) {
            spec = spec.and(ProductSpecifications.costLessOrEqualsThan(maxCost));
            //select p from ProductEntity p where true and p.price > minPrice and p.price < maxPrice
        }
        if (partTitle != null) {
            spec = spec.and(ProductSpecifications.titleLike(partTitle));
            //select p from ProductEntity p where true and p.price < and p.title > minPrice like %partTitle%

        }
        //select p from ProductEntity p where true and p.price > minPrice and p.price < maxPrice
        return productDAO.findAll(spec, PageRequest.of(page - 1, 10));
    }

    public ProductsEntity productEntityFromProductDTO(ProductDTO product) {
        ProductsEntity productsEntity= new ProductsEntity();
        productsEntity.setId(product.getId());
        productsEntity.setTitle(product.getTitle());
        productsEntity.setCost(product.getCost());
        return productsEntity;
    }
}
