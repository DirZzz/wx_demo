package com.zjc.wx_store.core.service.impl;

import com.zjc.wx_store.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public class BaseServiceImpl<REPO extends JpaRepository<E, ID>, E, ID extends Serializable> implements BaseService<E, ID> {
    @Autowired
    private REPO repo;

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
}
