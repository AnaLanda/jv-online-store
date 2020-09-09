package com.internet.shop.controllers;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import com.internet.shop.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private final ProductService productService = (ProductService) INJECTOR.getInstance(ProductService.class);
    private final ShoppingCartService shoppingCartService = (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user1 = new User("Tiabeanie", "login", "password");
        User user2 = new User("Luci", "login", "password");
        User user3 = new User("Elfo", "login", "password");
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        ShoppingCart shoppingCart = new ShoppingCart(user2.getId());
        shoppingCartService.create(shoppingCart);
        Product ukulele = new Product("Ukulele", 900);
        Product harmonica = new Product("Harmonica", 550);
        Product acousticGuitar = new Product("Acoustic Guitar", 5000);
        productService.create(ukulele);
        productService.create(harmonica);
        productService.create(acousticGuitar);
        req.getRequestDispatcher("/WEB-INF/views/inject-data.jsp").forward(req, resp);
    }
}
