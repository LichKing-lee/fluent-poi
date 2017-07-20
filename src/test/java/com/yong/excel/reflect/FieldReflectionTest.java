package com.yong.excel.reflect;

import com.yong.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 17..
 */
public class FieldReflectionTest {
    private FieldReflection fieldReflection;
    private TestClass testClass;

    @Before
    public void setUp(){
        this.fieldReflection = new FieldReflection();
        this.testClass = new TestClass(5L, "LichKing", 29);
    }

    @Test
    public void extractHeadNames() throws Exception {
        List<String> result = this.fieldReflection.extractHeadNames(this.testClass);

        assertThat(result, is(Arrays.asList("age", "이름")));
    }

    @Test
    public void extractCells() throws Exception {
        List<String> result = this.fieldReflection.extractCells(this.testClass);

        assertThat(result, is(Arrays.asList("29", "5")));
    }

    @AllArgsConstructor
    private static class TestClass{
        @Excel(head = "이름", priority = 10)
        private Long id;
        private String name;
        @Excel(priority = 5)
        private int age;
    }
}