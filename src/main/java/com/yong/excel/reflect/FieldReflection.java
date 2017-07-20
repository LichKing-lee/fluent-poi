package com.yong.excel.reflect;

import com.yong.excel.annotation.Excel;
import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class FieldReflection {
    private static Map<Class<?>, List<PriorityExcel>> map = new ConcurrentHashMap<>();

    public List<String> extractHeadNames(Object source){
        List<PriorityExcel> priorityExcels = readClassAndCached(source, field -> {
            Excel annotation = field.getAnnotation(Excel.class);
            String head = annotation.head();
            return new PriorityExcel(annotation.priority(), head.length() < 1 ? field.getName() : head);
        });

        return extractDatas(priorityExcels);
    }

    public List<String> extractCells(Object source){
        List<PriorityExcel> priorityExcels = readClassAndCached(source, field -> {
            try {
                field.setAccessible(true);
                return new PriorityExcel(field.getAnnotation(Excel.class).priority(), field.get(source));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        return extractDatas(priorityExcels);
    }

    private List<String> extractDatas(List<PriorityExcel> priorityExcels){
        return priorityExcels.stream()
                .map(excel -> excel.data)
                .map(this::toString)
                .collect(toList());
    }

    private List<PriorityExcel> readClassAndCached(Object source, Function<Field, PriorityExcel> function){
        Class<?> aClass = source.getClass();

        return map.computeIfAbsent(aClass, aClass1 -> {
            Field[] fields = aClass1.getDeclaredFields();
            System.out.println("test");

            return Arrays.stream(fields)
                    .filter(filed -> filed.isAnnotationPresent(Excel.class))
                    .map(function::apply)
                    .sorted(Comparator.comparingInt(excel -> excel.priority))
                    .collect(toList());
        });
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
