package com.zjc.wx_store.order.repository;

import com.zjc.wx_store.order.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Long> {
}
