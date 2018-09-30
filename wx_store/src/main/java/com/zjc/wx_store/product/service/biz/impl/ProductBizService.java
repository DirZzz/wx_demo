package com.zjc.wx_store.product.service.biz.impl;

import com.zjc.wx_store.core.service.biz.BaseBizService;
import com.zjc.wx_store.product.model.dto.ProductDTO;
import com.zjc.wx_store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBizService implements BaseBizService<ProductDTO, Long> {

    @Autowired
    private ProductService productService;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
//        productService.save();
        return null;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return null;
    }

    @Override
    public List<Long> delete(ProductDTO productDTO) {
        return null;
    }

    @Override
    public List<ProductDTO> list(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO get(Long aLong) {
        return null;
    }
}
