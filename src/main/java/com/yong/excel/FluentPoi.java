package com.yong.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class FluentPoi {
    private ExcelWorkbook excelWorkbook;

    public ExcelWorkbook newWorkbook(){
        return newWorkbook(new HSSFWorkbook());
    }

    ExcelWorkbook newWorkbook(Workbook workbook){
        this.excelWorkbook = new ExcelWorkbook(workbook);
        return this.excelWorkbook;
    }

    public Workbook exportWorkbook(){
        return this.excelWorkbook.getWorkbook();
    }
}
