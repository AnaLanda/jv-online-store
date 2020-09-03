package com.internet.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    Long id;
    List<Product> products = new ArrayList<>();
    Long userId;

    public ShoppingCart(Long userId) {
        this.userId = userId;
    }
}
