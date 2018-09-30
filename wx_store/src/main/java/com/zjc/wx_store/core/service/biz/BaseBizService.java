package com.zjc.wx_store.core.service.biz;

import java.io.Serializable;
import java.util.List;

public interface BaseBizService<DTO extends Serializable, ID extends Serializable> {

    DTO save(DTO dto);

    DTO update(DTO dto);

    List<ID> delete(DTO dto);

    List<DTO> list(DTO dto);

    DTO get(ID id);
}
