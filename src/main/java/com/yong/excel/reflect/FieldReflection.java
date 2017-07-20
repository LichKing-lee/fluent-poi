package com.yong.excel.reflect;

import com.yong.excel.annotation.Excel;
import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
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
            Excel annotation = field.getAnnotation(Excel.class);
            String head = annotation.head();
            return new PriorityExcel(annotation.priority(), head.length() < 1 ? field.getName() : head);
        });
    }

    public List<String> extractCells(Object source){
        return extractDatas(source, field -> {
            try {
                field.setAccessible(true);
                return new PriorityExcel(field.getAnnotation(Excel.class).priority(), field.get(source));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private List<String> extractDatas(Object source, Function<Field, PriorityExcel> function){
        Class<?> aClass = source.getClass();
        Field[] fields = aClass.getDeclaredFields();

        return Arrays.stream(fields)
                .filter(filed -> filed.isAnnotationPresent(Excel.class))
                .map(function::apply)
                .sorted(Comparator.comparingInt(excel -> excel.priority))
                .map(excel -> excel.data)
                .map(this::toString)
                .collect(toList());
    }

    private String toString(Object source){
        return Objects.isNull(source) ? "" : String.valueOf(source);
    }

    @AllArgsConstructor
    private static class PriorityExcel{
        public int priority;
        public Object data;
    }
}
