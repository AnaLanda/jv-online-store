package com.internet.shop.dao;

import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;

public interface ShoppingCartDao extends GenericDao<ShoppingCart, Long> {

    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean deleteProduct(ShoppingCart shoppingCart, Product product);

    boolean delete(ShoppingCart shoppingCart);

    void clear(ShoppingCart shoppingCart);
}
