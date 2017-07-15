package com.yong.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelMakeWrapper {
    private ExcelWorkbook excelWorkbook;

    public ExcelWorkbook newWorkbook(){
        this.excelWorkbook = new ExcelWorkbook(new HSSFWorkbook());
        return this.excelWorkbook;
    }

    public Workbook exportWorkbook(){
        return this.excelWorkbook.getWorkbook();
    }
}
