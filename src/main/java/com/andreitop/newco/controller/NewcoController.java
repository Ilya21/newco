package com.andreitop.newco.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewcoController<T> {
    ResponseEntity<List<T>> findAll();
}
