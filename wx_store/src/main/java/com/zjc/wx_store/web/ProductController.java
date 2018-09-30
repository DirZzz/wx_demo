package com.zjc.wx_store.web;

import com.zjc.wx_store.core.controller.CrudController;
import com.zjc.wx_store.product.model.dto.ProductDTO;
import com.zjc.wx_store.product.model.vo.ProductVO;
import com.zjc.wx_store.product.service.biz.impl.ProductBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
@RequestMapping("product")
public class ProductController extends CrudController<ProductDTO, ProductVO, Long, ProductBizService> {

    private final ProductBizService productBizService;

    @Autowired
    public ProductController(ProductBizService productBizService) {
        this.productBizService = productBizService;
    }

    @PostConstruct
    public void postConstruct() {
    }

}
