package com.andreitop.newco.repository;

import java.util.List;

public interface NewcoRepository<T> {
    List<T> findAll();

    T findById(final Long id);

    void save(final T elem);

    void delete(final Long id);

    void update(final T newElem);
}
