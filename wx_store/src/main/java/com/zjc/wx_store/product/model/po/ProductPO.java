package com.zjc.wx_store.product.model.po;

import com.zjc.wx_store.core.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_product")
public class ProductPO extends BaseModel implements Serializable {
    private String name;
    private Double advicePrice;
    private Double price;
    private Long picId;
    private String picIds;
    private String cDesc;
}
