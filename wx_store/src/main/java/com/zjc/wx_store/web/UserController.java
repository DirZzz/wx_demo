package com.zjc.wx_store.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("test")
    public void test() {
        System.out.println("ahha");
        throw new RuntimeException("it's error;");
    }

    public static void main(String[] args) {
    }
}
