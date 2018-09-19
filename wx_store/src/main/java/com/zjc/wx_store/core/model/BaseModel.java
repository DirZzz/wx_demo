package com.zjc.wx_store.core.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "comment '主键'")
    private Long id;

    private Long modifierId;

    private Long createId;

    private String code;

    @CreationTimestamp
    private LocalDateTime gmtCreate;

    @UpdateTimestamp
    private LocalDateTime gmtModifier;

    private Byte isDeleted = 0;

    private String remark;
}
