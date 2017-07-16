package com.yong.excel;

import com.yong.excel.merge.Merge;
import com.yong.excel.merge.MergeColumn;
import com.yong.excel.merge.MergeRow;
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

    /**
     * 열병합
     * 병합할 행 인덱스(rowIdx)와 열 범위(startColIdx, endColIdx)를 인자로 받음
     * 마지막 열 인덱스(endColIdx)는 병합에 포함하지않음
     * @param mergeColumn
     * @return
     */
    public ExcelSheet mergeColumn(MergeColumn mergeColumn){
        int rowIdx = mergeColumn.getRowIdx();
        this.sheet.addMergedRegion(mergeColumn.getMergeRange().getCellRangeAddress());

        return this;
    }

    /**
     * 행병합
     * 병합할 열 인덱스(colIdx)와 행 범위(startRowIdx, endRowIdx)를 인자로 받음
     * 마지막 행 인덱스(endRowIdx)는 병합에 포함하지않음
     * @param mergeRow
     * @return
     */
    public ExcelSheet mergeRow(MergeRow mergeRow){
        this.sheet.addMergedRegion(mergeRow.getMergeRange().getCellRangeAddress());

        return this;
    }

    public ExcelSheet merge(Merge merge){
        this.sheet.addMergedRegion(merge.getMergeRange().getCellRangeAddress());

        return this;
    }

    public int lastRowNum(){
        return this.rowIdx;
    }
}
