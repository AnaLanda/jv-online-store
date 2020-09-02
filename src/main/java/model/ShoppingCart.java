package model;

import java.util.List;

public class ShoppingCart {
    Long id;
    List<Product> products;
    Long userId;

    public ShoppingCart(List<Product> products, Long userId) {
        this.products = products;
        this.userId = userId;
    }
}
