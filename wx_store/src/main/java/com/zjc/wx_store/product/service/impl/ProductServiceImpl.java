package com.zjc.wx_store.product.service.impl;

import com.zjc.wx_store.core.service.impl.BaseServiceImpl;
import com.zjc.wx_store.product.model.Product;
import com.zjc.wx_store.product.repository.ProductRepository;
import com.zjc.wx_store.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductRepository, Product, Long> implements ProductService {

}
