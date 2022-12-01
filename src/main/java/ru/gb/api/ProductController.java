package ru.gb.api;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.DTO.ProductDTO;
import ru.gb.model.ProductsEntity;
import ru.gb.serveces.ProductService;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public Page<ProductDTO> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "part_title", required = false) String partTitle) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minCost, maxCost, partTitle, page).map(p -> new ProductDTO(p));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

//    @PostMapping
//    public ProductsEntity saveNewProduct(@RequestBody ProductsEntity product) {//dto
//        product.setId(null);
//        return productService.save(product);
//    }

    @PostMapping
    public ProductsEntity saveNewProduct(@RequestBody ProductDTO product) {//dto
        product.setId(null);
        return productService.save(productService.productEntityFromProductDTO(product));
    }

//    @PutMapping
//    public ProductsEntity updateStudent(@RequestBody ProductsEntity product) {//dto
//        return productService.save(product);
//    }

    @PutMapping
    public ProductsEntity updateStudent(@RequestBody ProductDTO product) {//dto
        return productService.save(productService.productEntityFromProductDTO(product));
    }


}
