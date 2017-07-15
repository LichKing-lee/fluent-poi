package com.yong.excel.row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelBody implements Iterable<ExcelRow> {
    private List<ExcelRow> rows;

    public ExcelBody(ExcelRow... rows){
        this(Arrays.asList(rows));
    }

    public ExcelBody(List<ExcelRow> rows){
        this.rows = new ArrayList<>(rows);
    }

    public int rowCount(){
        return rows.size();
    }

    @Override
    public Iterator<ExcelRow> iterator() {
        return new BodyIterator(this.rows);
    }

    private static class BodyIterator implements Iterator<ExcelRow>{
        private int cursor;
        private ExcelRow[] rows;

        private BodyIterator(List<ExcelRow> rows){
            this.rows = rows.toArray(new ExcelRow[0]);
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return rows.length > cursor;
        }

        @Override
        public ExcelRow next() {
            return rows[cursor++];
        }
    }
}
