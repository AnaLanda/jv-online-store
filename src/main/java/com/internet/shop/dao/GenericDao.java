package com.internet.shop.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    T create(T item);

    Optional<T> getById(Long id);

    List<T> getAll();

    T update(T item);

    boolean deleteById(Long id);

}
