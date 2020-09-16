package com.internet.shop.controllers;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.Role;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import com.internet.shop.service.UserService;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InjectDataController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.internet.shop");
    private final UserService userService =
            (UserService) injector.getInstance(UserService.class);
    private final ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);
    private final ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user1 = new User("Tiabeanie", "princess", "password123");
        user1.setRoles(Set.of(Role.of("USER")));
        userService.create(user1);
        User user2 = new User("Luci", "imp", "password1234");
        user2.setRoles(Set.of(Role.of("USER")));
        userService.create(user2);
        User user3 = new User("Elfo", "elf", "password12345");
        user3.setRoles(Set.of(Role.of("USER")));
        userService.create(user3);
        User admin = new User("Admin", "admin", "1234");
        admin.setRoles(Set.of(Role.of("ADMIN")));
        userService.create(admin);
        ShoppingCart shoppingCart1 = new ShoppingCart(user1.getId());
        shoppingCartService.create(shoppingCart1);
        ShoppingCart shoppingCart2 = new ShoppingCart(user2.getId());
        shoppingCartService.create(shoppingCart2);
        ShoppingCart shoppingCart3 = new ShoppingCart(user3.getId());
        shoppingCartService.create(shoppingCart3);
        Product ukulele = new Product("Ukulele", 900);
        Product harmonica = new Product("Harmonica", 550);
        Product acousticGuitar = new Product("Acoustic Guitar", 5000);
        productService.create(ukulele);
        productService.create(harmonica);
        productService.create(acousticGuitar);
        req.getRequestDispatcher("/WEB-INF/views/inject-data.jsp").forward(req, resp);
    }
}
