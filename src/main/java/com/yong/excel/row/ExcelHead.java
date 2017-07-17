package com.yong.excel.row;

import com.yong.excel.reflect.FieldReflection;

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

    public static ExcelHead invoke(Object source) {
        FieldReflection fieldReflection = new FieldReflection();

        return new ExcelHead(fieldReflection.extractCells(source));
    }
}
