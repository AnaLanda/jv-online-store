package com.internet.shop.dao.impl;

import com.internet.shop.dao.OrderDao;
import com.internet.shop.db.Storage;
import com.internet.shop.model.Order;
import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order(shoppingCart.getUserId());
        order.setProducts(shoppingCart.getProducts());
        Storage.orders.add(order);
        return order;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return Storage.orders.stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> get(Long orderId) {
        return Storage.orders.stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst();
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }

    @Override
    public boolean delete(Long orderId) {
        return Storage.orders
                .removeIf(order -> order.getId().equals(orderId));
    }
}
