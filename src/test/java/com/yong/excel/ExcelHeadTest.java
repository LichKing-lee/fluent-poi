package com.yong.excel;

import com.yong.excel.annotation.Excel;
import com.yong.excel.exception.NotFoundCellDataException;
import com.yong.excel.row.ExcelHead;
import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelHeadTest {
    @Test
    public void 리스트_생성(){
        ExcelHead head = new ExcelHead(Arrays.asList("가", "나", "다"));

        assertThat(head.getCellCount(), is(3));
    }

    @Test
    public void 가변인자_생성(){
        ExcelHead head = new ExcelHead("가", "나", "다", "라");

        assertThat(head.getCellCount(), is(4));
    }

    @Test(expected = NotFoundCellDataException.class)
    public void 인덱스_유효성_체크(){
        ExcelHead head = new ExcelHead("가", "나");
        head.getCellData(10);
    }

    @Test
    public void 애노테이션기반_생성(){
        TestClass testClass = new TestClass("LichKing", 29, "lcy9002@naver.com");

        ExcelHead excelHead = ExcelHead.from(testClass);

        assertThat(excelHead, equalTo(new ExcelHead("name", "나이")));
    }

    @AllArgsConstructor
    private static class TestClass{
        @Excel(priority = 3)
        private String name;
        @Excel(head = "나이", priority = 4)
        private int age;
        private String email;
    }
}