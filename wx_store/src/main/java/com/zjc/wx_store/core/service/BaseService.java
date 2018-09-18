package com.zjc.wx_store.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class BaseService<REPO extends JpaRepository<E, ID>, E, ID extends Serializable> {
    @Autowired
    private REPO repo;

    public E get(ID id) {
        return repo.getOne(id);
    }

    public void delete(ID id) {
        repo.deleteById(id);
    }

    public E update(E e) {
        return repo.saveAndFlush(e);
    }

    public E add(E e) {
        return repo.save(e);
    }

    public Page<E> list(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
