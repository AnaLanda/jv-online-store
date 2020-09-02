package com.internet.shop.model;

import java.util.List;

public class Order {
    Long id;
    List<Product> products;
    Long userId;

    public Order(List<Product> products, Long userId) {
        this.products = products;
        this.userId = userId;
    }
}
