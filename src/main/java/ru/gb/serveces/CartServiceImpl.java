package ru.gb.serveces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CartServiceImpl implements CartService {

    private final ProductService productService;

    @Autowired
    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }
    private  Map<LineItem, Integer> lineItemIntegerMap = new ConcurrentHashMap<>();



    @Override
    public void addProductToCart(long productId, int quantity) {
        LineItem key = new LineItem(productId);
        productService.findById(productId);
        lineItemIntegerMap.merge(key, quantity, Integer::sum);

    }

    @Override
    public void removeProductFromCart(long productId, int quantity) {
        LineItem key = new LineItem(productId);
        Integer count = lineItemIntegerMap.get(key);
        if (count != null) {
            if (count < quantity) {
                lineItemIntegerMap.remove(key);
            } else {
                lineItemIntegerMap.put(key, count - quantity);
            }
        }
    }

    @Override
    public List<LineItem> findAllInCart() {
        return new ArrayList<>(lineItemIntegerMap.keySet());
    }

}
