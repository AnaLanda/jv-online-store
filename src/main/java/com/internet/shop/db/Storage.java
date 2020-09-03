package com.internet.shop.db;

import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Order> orders = new ArrayList<>();
    public static final List<Product> products = new ArrayList<>();
    public static final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
    private static Long orderId = 0L;
    private static Long productId = 0L;
    private static Long cartId = 0L;
    private static Long userId = 0L;

    public static void addOrder(Order order) {
        order.setId(orderId);
        orderId++;
        orders.add(order);
    }

    public static void addProduct(Product product) {
        product.setId(productId);
        productId++;
        products.add(product);
    }

    public static void addCart(ShoppingCart shoppingCart) {
        shoppingCart.setId(cartId);
        cartId++;
        shoppingCarts.add(shoppingCart);
    }

    public static void addUser(User user) {
        user.setId(userId);
        userId++;
        users.add(user);
    }
}
