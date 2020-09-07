package com.internet.shop.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    // SHOULD I HAVE ALL CRUD OPERATIONS HERE?? IF NOT, I'LL ONLY HAVE GET OPERATIONS

    T create(T item);

    Optional<T> get(Long id);

    List<T> getAll();

    T update(T item);

    boolean delete(Long id);
}
