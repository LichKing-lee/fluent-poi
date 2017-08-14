package com.yong.excel;

import com.yong.excel.merge.MergeRow;
import com.yong.excel.row.ExcelHead;
import com.yong.excel.row.ExcelRow;
import com.yong.excel.row.ExcelRows;
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
        this.excelSheet = new FluentPoi()
                .newWorkbook()
                .newSheet();
    }

    @Test
    public void addHead() throws Exception {
        this.excelSheet.addHead(new ExcelHead("가", "나", "다"));

        assertThat(this.excelSheet.lastRowNum(), is(1));
    }

    @Test
    public void addRow() throws Exception {
        this.excelSheet.addRow(new ExcelRow("가", "나", "다"));
        this.excelSheet.addRow(new ExcelRow("가", "나", "다"));
        this.excelSheet.addRow(new ExcelRow("가", "나", "다"));

        assertThat(this.excelSheet.lastRowNum(), is(3));
    }

    @Test
    public void addRows(){
        this.excelSheet.addRows(new ExcelRows(new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다")));

        assertThat(this.excelSheet.lastRowNum(), is(3));
    }

    @Test
    public void merge(){
        this.excelSheet.addRows(new ExcelRows(new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다"),
                new ExcelRow("가", "나", "다")));

        this.excelSheet.merge(new MergeRow().colIdx(0).startRowIdx(0).endRowIdx(3));

        assertThat(this.excelSheet.mergeCellCount(), is(1));
    }
}