package com.yong.excel;

import com.yong.excel.annotation.Excel;
import com.yong.excel.row.ExcelRows;
import com.yong.excel.row.ExcelRow;
import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelRowsTest {
    @Test
    public void create_test(){
        ExcelRows excelRows = new ExcelRows(new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"));

        assertThat(excelRows.rowCount(), is(3));
    }

    @Test
    public void iterator_test(){
        ExcelRow excelRow = new ExcelRow("가", "나", "다");
        ExcelRows excelRows = new ExcelRows(new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"));

        Iterator<ExcelRow> rowIterator = excelRows.iterator();
        int callCount = 0;
        while(rowIterator.hasNext()){
            callCount++;
            assertThat(rowIterator.next(), is(excelRow));
        }

        assertThat(callCount, is(3));
    }

    @Test
    public void ofReflection_test(){
        TestClass instance1 = new TestClass("LichKing1", 29, "lcy9002@naver.com", "01012341234");
        TestClass instance2 = new TestClass("LichKing2", 30, "lcy9002@naver.com", "01012341234");
        TestClass instance3 = new TestClass("LichKing3", 31, "lcy9002@naver.com", "01012341234");

        ExcelRows excelRows = ExcelRows.from(Arrays.asList(instance1, instance2, instance3));

        assertThat(excelRows.rowCount(), is(3));
        assertThat(excelRows.getRow(1).getCellCount(), is(1));
    }

    @AllArgsConstructor
    private static class TestClass{
        @Excel(head = "이름", priority = 1)
        private String name;
        private int age;
        private String email;
        private String phoneNo;
    }
}