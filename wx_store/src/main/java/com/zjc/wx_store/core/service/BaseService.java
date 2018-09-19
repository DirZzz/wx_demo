package com.zjc.wx_store.core.service;

import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface BaseService<E, ID extends Serializable> {

    E get(ID id);

    Page<E> list(Pageable pageable);

    E save(E e);

    void delete(ID id);

    E update(E e);

     Page<E> find(E e, Pageable pageable);

}
