package com.zjc.wx_store.config;

import com.zjc.wx_store.web.ProductController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.zjc.wx_store.web"}, basePackageClasses = {ProductController.class})
public class ControllerHelper {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Object handleException(Exception e) {
        return e.getMessage();
    }

//    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    public Object handleIllegalException(IllegalArgumentException e) {
        return e.getMessage();
    }

}


