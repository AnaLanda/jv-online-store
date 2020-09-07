package com.internet.shop.dao.impl;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Dao
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product create(Product product) {
        Storage.addProduct(product);
        return product;
    }

    @Override
    public Optional<Product> getById(Long productId) {
        return Storage.products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
        List<Product> products = getAllProducts();
        IntStream.range(0, products.size())
                .filter(index
                        -> products.get(index).getId().equals(product.getId()))
                .forEach(index -> products.set(index, product));
        return product;
    }

    @Override
    public boolean deleteById(Long productId) {
        return Storage.products.removeIf(product -> product.getId().equals(productId));
    }

    @Override
    public List<Product> getAllProducts() {
        return Storage.products;
    }
}