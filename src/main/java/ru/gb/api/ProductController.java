package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;
import ru.gb.serveces.ProductService;

import java.util.Objects;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getProducts(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getProduct(@PathVariable Long id) {
        Product product = productService.getAllProducts().stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst().orElse(null);
        return product.getTitle() + " " + product.getCost() + " p.";
    }

    @GetMapping("/show_form")
    public String showFormPage() {
        return "product_form";
    }

    @PostMapping("/product_add")
    public String addProduct(@RequestParam String title, @RequestParam String cost) {
        Product product = new Product(title,Double.valueOf(cost));
        productService.add(product);
        return "redirect:/products";
    }

    @PostMapping("/{id}")
    @ResponseBody
    public String getProductById(@RequestParam Long id) {
        Product product = productService.getAllProducts().stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst().orElse(null);
        return product.getTitle() + " " + product.getCost() + " p.";
    }

    @GetMapping("/all")
    public String showProducts(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "products";
    }
}
