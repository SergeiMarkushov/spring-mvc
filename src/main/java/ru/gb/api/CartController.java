package ru.gb.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.DTO.ProductDTO;
import ru.gb.convertors.ProductConvertor;
import ru.gb.exceptions.ResourceNotFoundException;
import ru.gb.model.ProductsEntity;
import ru.gb.serveces.Cart;
import ru.gb.serveces.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final ProductService productService;
    private final Cart cart;
    private final ProductConvertor productConvertor;

    @GetMapping
    public List<ProductDTO> getCartList() {
        return cart.getProductList();
    }

    @PostMapping("/add/{id}")
    public void addProductToCart(@RequestParam(value = "id") Long id) {
        ProductsEntity product = productService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not fount id: " + id));
        ProductDTO productDTO = productConvertor.entityToDTO(product);
        cart.addProduct(productDTO);
    }

    @GetMapping("/remove/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found id: " + id));
        cart.delete(id);
    }
}
