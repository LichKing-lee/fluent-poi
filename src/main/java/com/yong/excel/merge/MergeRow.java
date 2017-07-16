package com.yong.excel.merge;

/**
 * Created by lichking on 2017. 7. 16..
 */
public class MergeRow implements Mergeable {
    private int colIdx;
    private int startRowIdx;
    private int endRowIdx;

    public MergeRow colIdx(int colIdx){
        this.colIdx = colIdx;

        return this;
    }

    public MergeRow startRowIdx(int startRowIdx){
        this.startRowIdx = startRowIdx;

        return this;
    }

    public MergeRow endRowIdx(int endRowIdx){
        this.endRowIdx = endRowIdx;

        return this;
    }

    @Override
    public MergeRange getMergeRange() {
        return new MergeRange(this.startRowIdx, this.endRowIdx - 1, this.colIdx, this.colIdx);
    }
}
