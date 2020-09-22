package com.internet.shop;

import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.lib.Injector;

public class Application {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ShoppingCartDao dao =
                (ShoppingCartDao) injector.getInstance(ShoppingCartDao.class);
    }
}
