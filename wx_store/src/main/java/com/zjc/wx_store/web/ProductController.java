package com.zjc.wx_store.web;

import com.zjc.wx_store.core.controller.BaseController;
import com.zjc.wx_store.product.model.Product;
import com.zjc.wx_store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("list")
    public Object list(Pageable pageable) {
        Product product = new Product();
        if (true) {
            throw new RuntimeException("it's error;");
        }
        Long modifierId = product.getModifierId();
        productService.saveBiz("hshs");
        Page<Product> list = productService.list(pageable);
        return list;
    }

}
