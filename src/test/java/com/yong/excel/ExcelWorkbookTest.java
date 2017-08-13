package com.yong.excel;

import com.yong.excel.mock.MockWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class ExcelWorkbookTest {
    private ExcelWorkbook excelWorkbook;

    @Before
    public void setUp(){
        this.excelWorkbook = new ExcelWorkbook(new MockWorkbook());
    }

    @Test
    public void newSheet() throws Exception {
        ExcelSheet sheet = this.excelWorkbook.newSheet();

        assertThat(sheet, is(notNullValue()));
    }

    @Test
    public void getWorkbook() throws Exception {
        Workbook workbook = this.excelWorkbook.getWorkbook();

        assertThat(workbook, is(notNullValue()));
    }
}