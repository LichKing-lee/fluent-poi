package com.yong.excel.row;

import com.yong.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelRowTest {
    @Test
    public void ofRelection() throws Exception {
        TestClass instance = new TestClass("LichKing", 29, "lcy9002@naver.com", "01012341234");

        ExcelRow row = ExcelRow.invoke(instance);

        assertThat(row.getCellCount(), is(1));
        assertThat(row, equalTo(new ExcelRow("LichKing")));
    }

    @AllArgsConstructor
    private static class TestClass{
        @Excel(priority = 3)
        private String name;
        private int age;
        private String email;
        private String phoneNo;
    }
}