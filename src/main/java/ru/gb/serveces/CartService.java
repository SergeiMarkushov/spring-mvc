package ru.gb.serveces;

import java.util.List;

public interface CartService {

    void addProductToCart(long productId,int quantity);
    void removeProductFromCart(long productId,int quantity);
    List<LineItem> findAllInCart();
}
