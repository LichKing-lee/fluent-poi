package com.yong.excel.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SheetLearnTest {
    private Sheet sheet;

    @Before
    public void setUp(){
        this.sheet = new HSSFWorkbook().createSheet();
    }

    @Test
    public void cellMerge(){
        Row row1 = this.sheet.createRow(0);
        Row row2 = this.sheet.createRow(1);
        Row row3 = this.sheet.createRow(2);

        Cell cell1 = row1.createCell(0);
        Cell cell12 = row1.createCell(1);
        Cell cell2 = row2.createCell(0);
        Cell cell22 = row2.createCell(1);
        Cell cell3 = row3.createCell(0);
        Cell cell32 = row3.createCell(1);

        cell1.setCellValue("a");
        cell12.setCellValue("b");
        cell2.setCellValue("c");
        cell22.setCellValue("d");
        cell3.setCellValue("e");
        cell32.setCellValue("f");

        this.sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
        this.sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
        this.sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));

        int num = this.sheet.getNumMergedRegions();

        assertThat(num, is(3));
    }
}
