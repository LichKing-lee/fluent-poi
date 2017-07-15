package com.yong.excel.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class FieldReflection {
    public List<String> fieldToList(Object source){
        Class<?> aClass = source.getClass();
        Field[] fields = aClass.getDeclaredFields();

        return Arrays.stream(fields)
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(source);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(this::toString)
                .collect(toList());
    }

    private String toString(Object source){
        return Objects.isNull(source) ? "" : String.valueOf(source);
    }
}
