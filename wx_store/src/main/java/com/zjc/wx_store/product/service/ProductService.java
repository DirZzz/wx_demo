package com.zjc.wx_store.product.service;

import com.zjc.wx_store.core.service.BaseService;
import com.zjc.wx_store.product.model.Product;

public interface ProductService extends BaseService<Product, Long> {

    void saveBiz(Object object);

}
