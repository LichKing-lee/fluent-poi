package com.yong.excel.reflect;

import com.yong.excel.annotation.Excel;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class FieldReflection {
    public List<String> extractHeadNames(Object source){
        return extractDatas(source, field -> {
            String head = field.getAnnotation(Excel.class).value();
            return head.length() < 1 ? field.getName() : head;
        });
    }

    public List<String> extractCells(Object source){
        return extractDatas(source, field -> {
            try {
                field.setAccessible(true);
                return field.get(source);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private List<String> extractDatas(Object source, Function<Field, ?> function){
        Class<?> aClass = source.getClass();
        Field[] fields = aClass.getDeclaredFields();

        return Arrays.stream(fields)
                .filter(filed -> filed.isAnnotationPresent(Excel.class))
                .map(function::apply)
                .map(this::toString)
                .collect(toList());
    }

    private String toString(Object source){
        return Objects.isNull(source) ? "" : String.valueOf(source);
    }
}
