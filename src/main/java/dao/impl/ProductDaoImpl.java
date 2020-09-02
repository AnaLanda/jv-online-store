package dao.impl;

import dao.ProductDao;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import db.Storage;
import lib.Dao;
import model.Product;

@Dao
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product create(Product product) {
        Storage.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> getById(Long productId) {
        return Storage.products.stream()
                .filter(x -> x.getId().equals(productId))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
        Product originalProduct = null;
        Optional<Product> originalProductOptional = Storage.products.stream()
                .filter(x -> x.getId().equals(product.getId()))
                .findFirst();
        if (originalProductOptional.isPresent()) {
            originalProduct = originalProductOptional.get();
            int index = Storage.products.indexOf(originalProduct);
            Storage.products.set(index, product);
        }
        return product;
    }

    @Override
    public boolean deleteById(Long productId) {
        Storage.products.removeIf(x -> x.getId().equals(productId));
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return Storage.products;
    }
}
