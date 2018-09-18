package com.zjc.wx_store.core.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long modifierId;

    private Long createId;

    private String code;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModifier;

    private Integer isDeleted;

    private String remark;
}
