package com.yong.excel;

import com.yong.excel.row.ExcelRows;
import com.yong.excel.row.ExcelHead;
import com.yong.excel.row.ExcelRow;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelSheetTest {
    private ExcelSheet excelSheet;

    @Before
    public void setUp(){
        this.excelSheet = new ExcelMakeWrapper()
                .newWorkbook()
                .newSheet();
    }

    @Test
    public void newHead() throws Exception {
        this.excelSheet.addHead(new ExcelHead("가", "나", "다"));

        assertThat(this.excelSheet.lastRowNum(), is(1));
    }

    @Test
    public void newRow() throws Exception {
        this.excelSheet.addHead(new ExcelRow("가", "나", "다"));
        this.excelSheet.addHead(new ExcelRow("가", "나", "다"));
        this.excelSheet.addHead(new ExcelRow("가", "나", "다"));

        assertThat(this.excelSheet.lastRowNum(), is(3));
    }

    @Test
    public void newBody(){
        this.excelSheet.addRows(new ExcelRows(new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다")));

        assertThat(this.excelSheet.lastRowNum(), is(3));
    }
}