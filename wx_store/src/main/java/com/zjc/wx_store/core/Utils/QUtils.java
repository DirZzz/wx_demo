package com.zjc.wx_store.core.Utils;

import com.querydsl.core.types.dsl.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


@SuppressWarnings("unchecked")
public class QUtils {

    public static <PB> BooleanExpression setQuery(PB paramBean) {
        EntityPathBase<PB> query = initQBean(paramBean.getClass());
        final BooleanExpression[] result = {null};
        final List<Field> beanFields = new LinkedList<>();
        if (query.getClass().getAnnotation(QueryField.class) == null) {
            Stream.of(paramBean.getClass().getFields())
                    .filter(field -> field.getAnnotationsByType(QueryField.class).length > 0)
                    .forEach(beanFields::add);
        } else {
            beanFields.addAll(Arrays.asList(paramBean.getClass().getFields()));
        }
        beanFields.stream().map(item -> {
            try {
                return resolveQueryExpression(item, query, paramBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).reduce(BooleanExpression::and).ifPresent(item -> result[0] = item);
        if (result[0] == null) {
            throw new RuntimeException("未设置任何参数");
        }
        return result[0];
    }

    private static <PB> EntityPathBase<PB> initQBean(Class<?> aClass) {
        String allName = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String qClassName = allName.replace(simpleName, "Q" + simpleName);
        try {
            Class<?> qClass = Class.forName(qClassName);
            return (EntityPathBase<PB>) qClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("为获取到相应的" + qClassName + "类");
        }
    }

    private static SimpleExpression resolveQueryExpression(Object qExpression, Object param, QueryType method) throws Exception {
        SimpleExpression expression = null;
        if (param instanceof String) {
            expression = (StringExpression) qExpression;
        }
        if (param instanceof Integer || param instanceof Long || param instanceof BigDecimal) {
            expression = (NumberExpression) qExpression;
        }
        if (param instanceof Boolean) {
            expression = (BooleanExpression) qExpression;
        } else {
            return expression;
        }
        Method invokeMethod = expression.getClass().getDeclaredMethod(method.getName(), param.getClass());
        return (BooleanExpression) invokeMethod.invoke(expression, param);
    }

    private static <QB extends SimpleExpression<PB>, PB> BooleanExpression resolveQueryExpression(Field paramField, QB query, PB param) throws Exception {
        Object QExpression = paramField.get(query);
        Object paramData = paramField.get(param);
        SimpleExpression expression = null;
        if (paramData instanceof String) {
            expression = (StringExpression) QExpression;
        }
        if (paramData instanceof Integer || paramData instanceof Long || paramData instanceof BigDecimal) {
            expression = (NumberExpression) QExpression;
        }
        if (paramData instanceof Boolean) {
            expression = (BooleanExpression) QExpression;
        }
        if (expression == null) {
            return null;
        }
        QueryField[] a = paramField.getAnnotationsByType(QueryField.class);
        QueryType methodName = a.length == 0 ? QueryType.EQ : a[0].method();
        Method method = expression.getClass().getDeclaredMethod(methodName.getName(), paramData.getClass());
        return (BooleanExpression) method.invoke(expression, paramData);
    }
}
