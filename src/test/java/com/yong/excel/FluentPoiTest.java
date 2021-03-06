package com.yong.excel;

import com.yong.excel.annotation.Excel;
import com.yong.excel.merge.Merge;
import com.yong.excel.merge.MergeColumn;
import com.yong.excel.merge.MergeRow;
import com.yong.excel.row.ExcelHead;
import com.yong.excel.row.ExcelRow;
import com.yong.excel.row.ExcelRows;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class FluentPoiTest {
    private FluentPoi fluentPoi;

    @Before
    public void setUp(){
        this.fluentPoi = new FluentPoi();
    }

    @Test
    public void newWorkbook_nonException(){
        this.fluentPoi.newWorkbook()
                .newSheet();
    }

    @Test
    @Ignore
    public void excel_make() throws IOException {
        this.fluentPoi.newWorkbook()
                .newSheet()
                .addHead(new ExcelHead("가", "나", "다", "라"))
                .addRow(new ExcelRow("1", "2", "3", "4"))
                .addRows(new ExcelRows(new ExcelRow("11", "22", null, "하하하")))
                .merge(new MergeColumn().rowIdx(1).startColIdx(2).endColIdx(4))
                .merge(new MergeRow().colIdx(1).startRowIdx(2).endRowIdx(4))
                .merge(new Merge().startRowIdx(10).endRowIdx(20).startColIdx(10).endColIdx(20));

        OutputStream osw = new FileOutputStream("test.xlsx");
        this.fluentPoi.exportWorkbook().write(osw);
    }

    @Test
    @Ignore
    public void excel_make_by_annotation() throws IOException {
        TestClass target1 = new TestClass("AA", 29, "lcy9002@naver.com", "qqq");
        TestClass target2 = new TestClass("BB", 29, "lcy0202@icloud.com", "sss");
        TestClass target3 = new TestClass("CC", 29, "lcy0202@ticketlink.co.kr", "aaa");

        this.fluentPoi.newWorkbook()
                .newSheet()
                .addHead(ExcelHead.from(target1))
                .addRow(ExcelRow.from(target2))
                .addRows(ExcelRows.from(Arrays.asList(target1, target2, target3)));

        OutputStream osw = new FileOutputStream("test.xlsx");
        this.fluentPoi.exportWorkbook().write(osw);
    }

    @AllArgsConstructor
    private static class TestClass{
        @Excel(head = "이름", priority = 11)
        private String name;
        @Excel(head = "나이", priority = 3)
        private int age;
        @Excel(priority = 2)
        private String email;
        private String etc;
    }
}