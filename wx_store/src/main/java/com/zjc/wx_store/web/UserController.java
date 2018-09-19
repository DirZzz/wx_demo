package com.zjc.wx_store.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class UserController {


    @GetMapping("test")
    public void test() {
        System.out.println("ahha");
        throw new RuntimeException("it's error;");
    }

    public static void main(String[] args) {
    }
}
