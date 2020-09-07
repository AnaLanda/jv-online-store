package com.internet.shop.service;

import java.util.List;

public interface GenericService<T> {

    //SHOULD I ADD THE CREATE & UPDATE & DELETE METHODS HERE????

    T get(Long id);

    List<T> getAll();
}
