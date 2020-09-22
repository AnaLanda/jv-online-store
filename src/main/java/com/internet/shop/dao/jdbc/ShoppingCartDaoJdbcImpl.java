package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;

@Dao
public class ShoppingCartDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        return false;
    }

    @Override
    public ShoppingCart create(ShoppingCart item) {
        return null;
    }

    @Override
    public Optional<ShoppingCart> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCart> getAll() {
        return null;
    }

    @Override
    public ShoppingCart update(ShoppingCart item) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
