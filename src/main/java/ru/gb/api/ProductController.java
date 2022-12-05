package ru.gb.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.DTO.ProductDTO;
import ru.gb.convertors.ProductConvertor;
import ru.gb.exceptions.ResourceNotFoundException;
import ru.gb.model.ProductsEntity;
import ru.gb.serveces.ProductService;
import ru.gb.validators.ProductValidator;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConvertor productConvertor;

    private final ProductValidator productValidator;
    @GetMapping
    public Page<ProductDTO> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "part_title", required = false) String partTitle) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(minCost, maxCost, partTitle, page).map(productConvertor::entityToDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        ProductsEntity product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found id= " + id));
        return productConvertor.entityToDTO(product);
    }


    @PostMapping
    public ProductDTO saveNewProduct(@RequestBody ProductDTO productDTO) {//dto
        productValidator.validate(productDTO);
        ProductsEntity productsEntity = productConvertor.dtoToEntity(productDTO);
        productsEntity = productService.save(productsEntity);
        return productConvertor.entityToDTO(productsEntity);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {//dto
        productValidator.validate(productDTO);
        ProductsEntity productsEntity = productService.update(productDTO);
        return productConvertor.entityToDTO(productsEntity);
    }


}
