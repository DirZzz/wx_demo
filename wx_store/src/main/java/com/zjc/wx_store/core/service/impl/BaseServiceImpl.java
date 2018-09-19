package com.zjc.wx_store.core.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.zjc.wx_store.core.Utils.QUtils;
import com.zjc.wx_store.core.repository.BaseRepository;
import com.zjc.wx_store.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public abstract class BaseServiceImpl<E, ID extends Serializable, REPO extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    @Autowired
    protected REPO repo;

    @Override
    public E get(ID id) {
        return repo.getOne(id);
    }

    public Page<E> list(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public E save(E o) {
        return repo.save(o);
    }

    @Override
    public void delete(ID id) {
        repo.deleteById(id);
    }

    @Override
    public E update(E o) {
        return repo.saveAndFlush(o);
    }

    @Override
    public Page<E> find(E e, Pageable pageable) {
        BooleanExpression booleanExpression = QUtils.setQuery(e);
        Page<E> all = repo.findAll(booleanExpression, pageable);
        return all;
    }

}
