package com.zjc.wx_store.product.service.impl;

import com.zjc.wx_store.core.service.impl.BaseServiceImpl;
import com.zjc.wx_store.product.model.Product;
import com.zjc.wx_store.product.repository.ProductRepository;
import com.zjc.wx_store.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long, ProductRepository> implements ProductService {



    @Override
    public void saveBiz(Object object) {
        Page<Product> all = this.repo.findAll(new PageRequest(1, 10));
        System.out.println("hahah");
    }
}
