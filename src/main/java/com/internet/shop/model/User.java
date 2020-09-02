package com.internet.shop.model;

public class User {
    Long id;
    String name;
    String login;
    String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
