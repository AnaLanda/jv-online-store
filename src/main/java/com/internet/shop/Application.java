package com.internet.shop;

import com.internet.shop.dao.jdbc.ProductDaoJdbcImpl;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;

public class Application {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductDaoJdbcImpl productDaoJdbc =
                (ProductDaoJdbcImpl) injector.getInstance(ProductDaoJdbcImpl.class);
        Product product = new Product("Ukulele", 120.99);
        product.setId(1L);
        System.out.println("Added product to DB: "
                + productDaoJdbc.create(product));
        System.out.println("Product retrieved from DB by ID: "
                + productDaoJdbc.getById(1L));
        System.out.println("All products in DB: "
                + productDaoJdbc.getAll());
        product.setName("Second-hand Ukulele, like new condition");
        product.setPrice(100);
        System.out.println("Updated product :" + productDaoJdbc.update(product));
        System.out.println("Deleted product: " + productDaoJdbc.deleteById(1L));
    }
}
