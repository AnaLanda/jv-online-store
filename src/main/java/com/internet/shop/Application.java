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
        System.out.println("Original storage list: " + productService.getAllProducts());
        product1.setName("Second-hand guitar");
        product1.setPrice(8000);
        productService.update(product1);
        System.out.println("Storage list with an updated product: "
                + productService.getAllProducts());
        productService.deleteById(product2.getId());
        System.out.println("Storage list after a product was deleted: "
                + productService.getAllProducts());
    }
}
