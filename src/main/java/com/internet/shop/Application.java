package com.internet.shop;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import com.internet.shop.service.UserService;

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
        System.out.println("Original storage list: " + productService.getAllProducts() + "\n");
        product1.setName("Second-hand guitar");
        product1.setPrice(8000);
        productService.update(product1);
        System.out.println("Storage list with an updated product: "
                + productService.getAllProducts() + "\n");
        productService.deleteById(product2.getId());
        System.out.println("Storage list after a product was deleted: "
                + productService.getAllProducts() + "\n");
        System.out.println("Updated items: " + productService.getAllProducts() + "\n");

        UserService userService = (UserService) injector.getInstance(UserService.class);
        User user1 = new User("Dylan", "guitar_lover", "dogsarethebest_101");
        User user2 = new User("Davina", "cello_player", "dogsarethebest_102");
        userService.create(user1);
        userService.create(user2);
        System.out.println("Users: " + userService.getAll() + "\n");
        user1.setLogin("aspiring_musician");
        userService.update(user1);
        System.out.println("User1 with updated login: " + userService.get(user1.getId()) + "\n");

        ShoppingCartService shoppingCartService
                = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        ShoppingCart shoppingCart1 = new ShoppingCart(user1.getId());
        ShoppingCart shoppingCart2 = new ShoppingCart(user2.getId());
        shoppingCartService.create(shoppingCart1);
        shoppingCartService.create(shoppingCart2);
        System.out.println("First user's shopping cart: " + shoppingCart1 + "\n");
        System.out.println("Second user's shopping cart: " + shoppingCart2 + "\n");
        shoppingCartService.addProduct(shoppingCart1, product1);
        shoppingCartService.addProduct(shoppingCart1, product2);
        shoppingCartService.addProduct(shoppingCart1, product3);
        System.out.println("First user's shopping cart with products: "
                + shoppingCartService.getByUserId(user1.getId()) + "\n");
        shoppingCartService.deleteProduct(shoppingCartService.getByUserId(user1.getId()),
                productService.getById(product1.getId()));
        System.out.println("First user's shopping cart with one remaining product: "
                + shoppingCartService.getByUserId(user1.getId()) + "\n");
    }
}
