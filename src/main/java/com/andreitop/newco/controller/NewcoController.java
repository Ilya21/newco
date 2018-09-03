package com.andreitop.newco.controller;

import java.util.List;

public interface NewcoController<T> {
     List<T> findAll();

     T findById(final Long id);

     void create(final T elem);

     void delete(final Long id);

     void update(final T newElem);
}
