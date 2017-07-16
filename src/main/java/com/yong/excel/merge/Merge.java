package com.yong.excel.merge;

/**
 * Created by lichking on 2017. 7. 16..
 */
public class Merge implements Mergeable {
    private int startRowIdx;
    private int endRowIdx;
    private int startColIdx;
    private int endColIdx;

    public Merge startColIdx(int startColIdx){
        this.startColIdx = startColIdx;

        return this;
    }

    public Merge endColIdx(int endColIdx){
        this.endColIdx = endColIdx;

        return this;
    }

    public Merge startRowIdx(int startRowIdx){
        this.startRowIdx = startRowIdx;

        return this;
    }

    public Merge endRowIdx(int endRowIdx){
        this.endRowIdx = endRowIdx;

        return this;
    }

    @Override
    public MergeRange getMergeRange() {
        return new MergeRange(this.startRowIdx, this.endRowIdx, this.startColIdx, this.endColIdx);
    }
}
