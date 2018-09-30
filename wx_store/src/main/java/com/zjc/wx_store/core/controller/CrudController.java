package com.zjc.wx_store.core.controller;

import com.zjc.wx_store.core.model.ResultData;
import com.zjc.wx_store.core.service.biz.BaseBizService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class CrudController<DTO extends Serializable, VO, ID extends Serializable, BS extends BaseBizService<DTO, ID>> {

    @Autowired
    private BS bizService;


    @GetMapping("/{id}")
    final protected ResultData get(@PathVariable("id") ID id, VO vo) {
        DTO dto = bizService.get(id);
        BeanUtils.copyProperties(dto, vo);

        return ResultData.initSuccess(vo);
    }

    @GetMapping
    final protected ResultData list(DTO dto, Pageable pageable, VO vo) {

        return null;
    }


    @PostMapping
    final protected ResultData add(DTO po) {
        DTO save = bizService.save(po);
        return ResultData.initSuccess(save);
    }

    @PutMapping
    final protected ResultData update(DTO po) {
        DTO save = bizService.update(po);

        return null;
    }


    @DeleteMapping
    final protected ResultData delete(DTO dto) {
        bizService.delete(dto);
        return null;
    }


}
