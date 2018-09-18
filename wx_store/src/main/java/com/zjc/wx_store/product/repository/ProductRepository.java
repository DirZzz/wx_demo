package com.zjc.wx_store.product.repository;

import com.zjc.wx_store.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
