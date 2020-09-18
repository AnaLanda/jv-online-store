package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoJDBCImpl implements ProductDao {
    @Override
    public Product create(Product item) {
        return null;
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product update(Product item) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
