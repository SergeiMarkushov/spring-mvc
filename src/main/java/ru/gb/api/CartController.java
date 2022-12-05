package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.serveces.CartService;
import ru.gb.serveces.LineItem;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{productId}/product")
    public void addProductToCart(@PathVariable("productId") Long productId, @RequestParam("quantity") Integer quantity) {
        cartService.addProductToCart(productId,quantity);
    }

    @GetMapping
    public List<LineItem> showCart () {
        return cartService.findAllInCart();
    }

    @DeleteMapping("/remove/{productId}/product")
    public void deleteProductFroCart(@PathVariable("productId") Long productId) {
        cartService.removeProductFromCart(productId,1);
    }
}
