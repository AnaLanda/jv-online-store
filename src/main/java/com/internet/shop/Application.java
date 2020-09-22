package com.internet.shop;

import com.internet.shop.dao.UserDao;
import com.internet.shop.exceptions.DataProcessingException;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.User;
import com.internet.shop.model.Role;
import com.internet.shop.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Application {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
//        UserDao dao =
//                (UserDao) injector.getInstance(UserDao.class);
//        User user = new User("Nastia", "Java_//_student", "password123456");
//        user.setRoles(Set.of(Role.of("USER")));
//        System.out.println("Added user to DB: "
//                + dao.create(user));
//
//        System.out.println("Retrieved from DB by ID: "
//                + dao.getById(5L));
//        System.out.println("All users in DB: "
//                + dao.getAll());
//        user.setName("Bambina");
//        user.setLogin("nana");
//        System.out.println("Updated product :" + dao.update(user));
//        System.out.println("Deleted product: " + dao.deleteById(5L));


    }
}
