package com.internet.shop;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;

public class Application {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        Product product1 = new Product("Guitar", 16000);
        Product product2 = new Product("Ukulele", 5000);
        Product product3 = new Product("Harmonica", 300);
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
        System.out.println("Original items: " + productService.getAllProducts());
        product1.setName("Second-hand guitar");
        product1.setPrice(8000);
        productService.update(product1);
        productService.deleteById(product2.getId());
        System.out.println("Updated items: " + productService.getAllProducts());
    }
}
