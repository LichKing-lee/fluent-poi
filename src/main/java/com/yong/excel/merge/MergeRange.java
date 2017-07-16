package com.yong.excel.merge;

import org.apache.poi.ss.util.CellRangeAddress;

/**
 * Created by lichking on 2017. 7. 16..
 */
public class MergeRange {
    private CellRangeAddress cellRangeAddress;

    MergeRange(int startRowIdx, int endRowIdx, int startColIdx, int endColIdx){
        this.cellRangeAddress = new CellRangeAddress(startRowIdx, endRowIdx, startColIdx, endColIdx);
    }

    public CellRangeAddress getCellRangeAddress(){
        return this.cellRangeAddress;
    }
}
