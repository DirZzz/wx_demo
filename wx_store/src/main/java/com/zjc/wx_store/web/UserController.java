package com.zjc.wx_store.web;

import com.zjc.wx_store.order.model.SysUser;
import com.zjc.wx_store.order.service.impl.SysUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

//@RestController
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Test
    public void test() {
        Page<SysUser> list = sysUserService.list(new PageRequest(1, 10));
        System.out.println(list);
    }

    public static void main(String[] args) {
//        Page<SysUser> list = sysUserService.list(new PageRequest(1, 10));
//        System.out.println(list);
    }
}
