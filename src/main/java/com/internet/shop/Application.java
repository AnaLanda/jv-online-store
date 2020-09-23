package com.internet.shop;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.dao.UserDao;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Role;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.ShoppingCartService;

import java.util.Set;

public class Application {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        UserDao udao = (UserDao) injector.getInstance(UserDao.class);
        ProductDao pdao = (ProductDao) injector.getInstance(ProductDao.class);
        ShoppingCartDao dao = (ShoppingCartDao) injector.getInstance(ShoppingCartDao.class);
        ShoppingCartService service = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        User user = new User("Dylan", "dog123", "1234");
        user.setRoles(Set.of(Role.of("USER")));
       // udao.create(user);

        ShoppingCart shoppingCart = new ShoppingCart(udao.getById(11L).get().getId());
 //       dao.create(shoppingCart);

//        service.addProduct();
        System.out.println(dao.getById(11L));
        service.addProduct(dao.getById(7L).get(), pdao.getById(6L).get());
        System.out.println(dao.getById(11L));
    }
}
