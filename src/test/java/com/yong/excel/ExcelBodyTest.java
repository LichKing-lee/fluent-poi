package com.yong.excel;

import com.yong.excel.row.ExcelBody;
import com.yong.excel.row.ExcelRow;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelBodyTest {
    @Test
    public void create_test(){
        ExcelBody excelBody = new ExcelBody(new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"));

        assertThat(excelBody.rowCount(), is(3));
    }

    @Test
    public void iterator_test(){
        ExcelRow excelRow = new ExcelRow("가", "나", "다");
        ExcelBody excelBody = new ExcelBody(new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"));

        Iterator<ExcelRow> rowIterator = excelBody.iterator();
        int callCount = 0;
        while(rowIterator.hasNext()){
            callCount++;
            assertThat(rowIterator.next(), is(excelRow));
        }

        assertThat(callCount, is(3));
    }
}