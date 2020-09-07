package com.internet.shop.dao.impl;

import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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
    public ShoppingCart update(ShoppingCart shoppingCart) {
        List<ShoppingCart> shoppingCarts = getAll();
        IntStream.range(0, shoppingCarts.size())
                .filter(index
                        -> shoppingCarts.get(index).getId().equals(shoppingCart.getId()))
                .forEach(index -> shoppingCarts.set(index, shoppingCart));
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> getByUserId(Long userId) {
        return Storage.shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<ShoppingCart> getAll() {
        return Storage.shoppingCarts;
    }

    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        return Storage.shoppingCarts
                .removeIf(shoppingCartInStorage -> shoppingCartInStorage.getId()
                        .equals(shoppingCart.getId()));
    }
}
