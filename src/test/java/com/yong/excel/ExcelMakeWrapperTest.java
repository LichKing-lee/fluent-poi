package com.yong.excel;

import com.yong.excel.annotation.Excel;
import com.yong.excel.merge.Merge;
import com.yong.excel.merge.MergeColumn;
import com.yong.excel.merge.MergeRow;
import com.yong.excel.row.ExcelBody;
import com.yong.excel.row.ExcelHead;
import com.yong.excel.row.ExcelRow;
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
public class ExcelMakeWrapperTest {
    private ExcelMakeWrapper excelMakeWrapper;

    @Before
    public void setUp(){
        this.excelMakeWrapper = new ExcelMakeWrapper();
    }

    @Test
    public void newWorkbook_nonException(){
        this.excelMakeWrapper.newWorkbook()
            .newSheet();
    }

    @Test
    @Ignore
    public void excel_make() throws IOException {
        this.excelMakeWrapper.newWorkbook()
                .newSheet()
                .newHead(new ExcelHead("가", "나", "다", "라"))
                .newRow(new ExcelRow("1", "2", "3", "4"))
                .newBody(new ExcelBody(new ExcelRow("11", "22", null, "하하하")))
                .newBody(new ExcelBody(new ExcelRow(""), new ExcelRow("aqqqqq")))
                .merge(new MergeColumn().rowIdx(1).startColIdx(2).endColIdx(4).getMergeRange())
                .merge(new MergeRow().colIdx(1).startRowIdx(2).endRowIdx(4).getMergeRange())
                .merge(new Merge().startRowIdx(10).endRowIdx(20).startColIdx(10).endColIdx(20).getMergeRange());

        OutputStream osw = new FileOutputStream("test.xlsx");
        this.excelMakeWrapper.exportWorkbook().write(osw);
    }

    @Test
    @Ignore
    public void excel_make_by_annotation() throws IOException {
        TestClass target1 = new TestClass("AA", 29, "lcy9002@naver.com", "qqq");
        TestClass target2 = new TestClass("BB", 29, "lcy0202@icloud.com", "sss");
        TestClass target3 = new TestClass("CC", 29, "lcy0202@ticketlink.co.kr", "aaa");

        this.excelMakeWrapper.newWorkbook()
                .newSheet()
                .newHead(ExcelHead.invoke(target1))
                .newRow(ExcelRow.invoke(target2))
                .newBody(ExcelBody.invoke(Arrays.asList(target1, target2, target3)));

        OutputStream osw = new FileOutputStream("test.xlsx");
        this.excelMakeWrapper.exportWorkbook().write(osw);
    }

    @AllArgsConstructor
    private static class TestClass{
        @Excel("이름")
        private String name;
        @Excel("나이")
        private int age;
        @Excel
        private String email;
        private String etc;
    }
}