package com.internet.shop.dao.impl;

import com.internet.shop.dao.UserDao;
import com.internet.shop.db.Storage;
import com.internet.shop.model.User;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public User create(User user) {
        Storage.addUser(user);
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        return Storage.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User update(User user) {
        return get(user.getId())
                .map(originalUser -> user)
                .orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        return Storage.users
                .removeIf(user -> user.getId().equals(id));
    }
}
