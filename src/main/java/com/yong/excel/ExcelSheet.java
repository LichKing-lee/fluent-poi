package com.yong.excel;

import com.yong.excel.row.ExcelBody;
import com.yong.excel.row.ExcelHead;
import com.yong.excel.row.ExcelRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelSheet {
    private Sheet sheet;
    private int rowIdx;

    ExcelSheet(Sheet sheet) {
        this(sheet, 0);
    }

    ExcelSheet(Sheet sheet, int rowIdx) {
        this.sheet = sheet;
        this.rowIdx = rowIdx;
    }

    public ExcelSheet newHead(ExcelHead excelHead){
        return addRow(excelHead);
    }

    public ExcelSheet newRow(ExcelRow excelRow){
        return addRow(excelRow);
    }

    public ExcelSheet newBody(ExcelBody excelBody) {
        for(ExcelRow row : excelBody){
            this.addRow(row);
        }

        return this;
    }

    private ExcelSheet addRow(Iterable<String> iterable){
        Row row = this.sheet.createRow(this.rowIdx++);

        Iterator<String> iterator = iterable.iterator();
        for(int i = 0; iterator.hasNext(); i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(iterator.next());
        }

        return this;
    }

    public int lastRowNum(){
        return this.rowIdx;
    }
}
