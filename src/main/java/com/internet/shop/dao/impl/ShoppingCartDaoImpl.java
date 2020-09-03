package com.internet.shop.dao.impl;

import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import java.util.Optional;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        Storage.addCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {
        if (!Storage.products.contains(product)) {
            System.out.println("Unfortunately, " + product.getName()
                    + " cannot be added to the cart. \n");
            return shoppingCart;
        }
        getByUserId(shoppingCart.getUserId())
                .get()
                .getProducts()
                .add(product);
        return shoppingCart;
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
        return getByUserId(shoppingCart.getUserId())
                .get()
                .getProducts()
                .remove(product);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().clear();
    }

    @Override
    public Optional<ShoppingCart> getByUserId(Long userId) {
        return Storage.shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        return Storage.shoppingCarts
                .removeIf(shoppingCartInStorage -> shoppingCartInStorage.getId()
                        .equals(shoppingCart.getId()));
    }
}
