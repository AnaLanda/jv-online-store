package com.internet.shop.service;

import com.internet.shop.model.User;

public interface UserService extends GenericService<User> {

    User create(User user);

    User update(User user);

    boolean delete(Long id);
}
