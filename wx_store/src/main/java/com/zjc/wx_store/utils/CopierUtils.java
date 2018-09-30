package com.zjc.wx_store.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

/**
 * 对Cglib BeanCopier 做了封装 便于简化开发
 * Created by duanmu on 8/21/16.
 */
public class CopierUtils {
    private static final Map<String, BeanCopier> beanCopierCache = new ConcurrentHashMap<>();


    private static void copyProperties(Object source, Object target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target, null);
    }

    private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!beanCopierCache.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            beanCopierCache.put(beanKey, copier);
        } else {
            copier = beanCopierCache.get(beanKey);
        }
        return copier;
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        T t = null;
        try {
            t = targetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        copyProperties(source, t);
        return t;
    }



}
