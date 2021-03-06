package com.yong.excel.row;

import com.yong.excel.reflect.FieldReflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class ExcelRows implements Iterable<ExcelRow> {
    private List<ExcelRow> rows;

    public static ExcelRows from(List<?> source) {
        FieldReflection fieldReflection = new FieldReflection();

        List<ExcelRow> rows = source.stream()
                .map(fieldReflection::extractCells)
                .map(ExcelRow::new)
                .collect(toList());

        return new ExcelRows(rows);
    }

    public ExcelRows(ExcelRow... rows){
        this(Arrays.asList(rows));
    }

    public ExcelRows(List<ExcelRow> rows){
        this.rows = new ArrayList<>(rows);
    }

    public int rowCount(){
        return rows.size();
    }

    public ExcelRow getRow(int idx){
        return this.rows.get(idx);
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
