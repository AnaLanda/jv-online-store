package com.internet.shop;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;

public class Application {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductDao productDao =
                (ProductDao) injector.getInstance(ProductDao.class);
        Product product = new Product("Ukulele", 120.99);
        product.setId(1L);
        System.out.println("Added product to DB: "
                + productDao.create(product));
        System.out.println("Product retrieved from DB by ID: "
                + productDao.getById(1L));
        System.out.println("All products in DB: "
                + productDao.getAll());
        product.setName("Second-hand Ukulele, like new condition");
        product.setPrice(100);
        System.out.println("Updated product :" + productDao.update(product));
        System.out.println("Deleted product: " + productDao.deleteById(1L));
    }
}
