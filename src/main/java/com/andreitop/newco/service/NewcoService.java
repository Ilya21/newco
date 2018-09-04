package com.andreitop.newco.service;

import java.util.List;

public interface NewcoService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T elem);

    void delete(Long id);

    void update(T newElem);
}
