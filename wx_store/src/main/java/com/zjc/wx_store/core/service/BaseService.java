package com.zjc.wx_store.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseService<E, ID extends Serializable> {

    E get(ID id);

    Page<E> list(Pageable pageable);

    E save(E e);

    void delete(ID id);

    E update(E e);

}
