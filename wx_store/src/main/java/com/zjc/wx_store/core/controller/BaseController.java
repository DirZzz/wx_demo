package com.zjc.wx_store.core.controller;

import com.zjc.wx_store.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public class BaseController<VO, PO, E, ID extends Serializable, S extends BaseService<E, ID>> {

    @Autowired
    private S s;

    @GetMapping("/{id}")
    public VO get(@PathVariable("id") ID id) {
        E e = s.get(id);
        VO vo = this.transBeanToVO(e);
        return vo;
    }

    @PostMapping()
    public void add(PO po) {
        E e = this.transPOToBean(po);
        s.save(e);
    }

    @PutMapping()
    public void update(PO po) {
        E e = this.transPOToBean(po);
        s.save(e);
    }

    @GetMapping("")
    public VO get(PO po, Pageable pageable) {
        E e = this.transPOToBean(po);
        s.list(pageable);
        return null;
    }

    @DeleteMapping
    public Object delete(List<ID> ids) {
        ids.forEach(s::delete);
        return null;
    }

    private E transPOToBean(PO po) {
        return null;
    }

    private VO transBeanToVO(E e) {
        return null;
    }


}
