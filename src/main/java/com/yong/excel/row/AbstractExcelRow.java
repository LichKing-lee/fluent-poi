package com.yong.excel.row;

import com.yong.excel.exception.NotFoundCellDataException;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 15..
 */
@EqualsAndHashCode
public abstract class AbstractExcelRow implements Iterable<String> {
    protected List<String> cellDatas;

    public AbstractExcelRow(String... cellDatas){
        this(Arrays.asList(cellDatas));
    }

    public AbstractExcelRow(List<String> cellDatas){
        this.cellDatas = new ArrayList<>(cellDatas);
    }

    public String getCellData(int idx){
        checkValidIndex(idx);

        return this.cellDatas.get(idx);
    }

    public void addCellData(String cellData){
        this.cellDatas.add(cellData);
    }

    public int getCellCount(){
        return this.cellDatas.size();
    }

    @Override
    public Iterator<String> iterator() {
        return this.cellDatas.iterator();
    }

    private void checkValidIndex(int idx){
        if(idx < 0 || idx >= this.cellDatas.size()){
            throw new NotFoundCellDataException("cellCount :: " + this.cellDatas.size() + " index :: " + idx);
        }
    }
}
