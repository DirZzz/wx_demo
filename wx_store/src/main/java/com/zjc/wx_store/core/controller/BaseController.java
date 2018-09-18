package com.zjc.wx_store.core.controller;

import com.zjc.wx_store.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class BaseController<VO, PO, E, ID extends Serializable, S extends BaseService<E, ID>> {

    @Autowired
    private S s;

    public VO get(ID id) {
        E e = s.get(id);
        VO vo = this.transBeanToVO(e);
        return vo;
    }

    public void add(PO po){
        E e = this.transPOToBean(po);
        s.save(e);
    }

    private E transPOToBean(PO po) {
        return null;
    }

    private VO transBeanToVO(E e) {
        return null;
    }


}
