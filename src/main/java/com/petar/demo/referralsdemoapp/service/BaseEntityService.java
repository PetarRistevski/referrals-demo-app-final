package com.petar.demo.referralsdemoapp.service;

import java.util.Collection;
import java.util.Optional;

public interface BaseEntityService<T> {
    Optional<T> findById(Long id);

    Collection<T> findAll();

    T save(T entity);
}