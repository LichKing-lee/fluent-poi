package com.yong.excel;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelWorkbook {
    private Workbook workbook;

    ExcelWorkbook(Workbook workbook){
        this.workbook = workbook;
    }

    public ExcelSheet newSheet(){
        return new ExcelSheet(this.workbook.createSheet());
    }

    Workbook getWorkbook(){
        return this.workbook;
    }
}
