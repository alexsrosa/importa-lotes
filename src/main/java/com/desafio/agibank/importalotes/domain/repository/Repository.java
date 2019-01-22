package com.desafio.agibank.importalotes.domain.repository;

import java.util.List;

public interface Repository<E> {

    void clear();

    void create(E entity);

    List<E> findAll();
}
