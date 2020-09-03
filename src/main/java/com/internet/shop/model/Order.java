package com.internet.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Long id;
    List<Product> products = new ArrayList<>();
    Long userId;

    public Order(Long userId) {
        this.userId = userId;
    }
}
