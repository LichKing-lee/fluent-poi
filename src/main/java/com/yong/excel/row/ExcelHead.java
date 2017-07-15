package com.yong.excel.row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelHead extends AbstractExcelRow {
    public ExcelHead(String... cellDatas){
        this(Arrays.asList(cellDatas));
    }

    public ExcelHead(List<String> cellDatas){
        this.cellDatas = new ArrayList<>(cellDatas);
    }
}
