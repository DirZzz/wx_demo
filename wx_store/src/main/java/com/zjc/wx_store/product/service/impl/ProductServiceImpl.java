package com.zjc.wx_store.product.service.impl;

import com.zjc.wx_store.core.service.impl.BaseServiceImpl;
import com.zjc.wx_store.product.model.po.ProductPO;
import com.zjc.wx_store.product.repository.ProductRepository;
import com.zjc.wx_store.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductPO, Long, ProductRepository> implements ProductService {


}
