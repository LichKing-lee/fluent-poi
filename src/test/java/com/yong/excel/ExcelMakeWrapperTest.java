package com.yong.excel;

import com.yong.excel.merge.Merge;
import com.yong.excel.merge.MergeColumn;
import com.yong.excel.merge.MergeRow;
import com.yong.excel.row.ExcelBody;
import com.yong.excel.row.ExcelHead;
import com.yong.excel.row.ExcelRow;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
}