package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;
import ru.gb.model.ProductRepository;
import ru.gb.serveces.ProductService;

import java.util.Objects;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping()
    public String getProducts(Model model) {
        model.addAttribute("productList", productRepository.getAllProducts());
        return "products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getProduct(@PathVariable Long id) {
        Product product = productService.getProductList().stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst().orElse(null);
        return product.getTitle() + " " + product.getCost() + " p.";
    }

    @GetMapping("/show_form")
    public String showFormPage() {
        return "product_form";
    }

    @GetMapping("/product_add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam String cost) {
        Product product = new Product(id,title,Double.valueOf(cost));
        productRepository.add(product);
        return "redirect:/products";
    }

    @GetMapping("/all")
    public String showProducts(Model model) {
        model.addAttribute("productList", productRepository.getProductList());
        return "products";
    }
}
