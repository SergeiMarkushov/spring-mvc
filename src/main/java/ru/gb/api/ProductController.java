package ru.gb.api;

import org.springframework.web.bind.annotation.*;
import ru.gb.model.ProductsEntity;
import ru.gb.serveces.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<ProductsEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("/products")
    public ProductsEntity saveNewProduct(@RequestBody ProductsEntity product) {
        return productService.save(product);
    }


    @GetMapping("/products/find_by_price")
    public List<ProductsEntity> findAllByCostBetween(@RequestParam Integer min,@RequestParam Integer max) {
        return  productService.findAllByCostBetween(min,max);
    }
}
