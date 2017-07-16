package com.yong.excel.merge;

/**
 * Created by lichking on 2017. 7. 16..
 */
public class MergeColumn implements Mergeable {
    private int rowIdx;
    private int startColIdx;
    private int endColIdx;

    public MergeColumn rowIdx(int rowIdx){
        this.rowIdx = rowIdx;

        return this;
    }

    public MergeColumn startColIdx(int startColIdx){
        this.startColIdx = startColIdx;

        return this;
    }

    public MergeColumn endColIdx(int endColIdx){
        this.endColIdx = endColIdx;

        return this;
    }

    @Override
    public MergeRange getMergeRange() {
        return new MergeRange(this.rowIdx, this.rowIdx, this.startColIdx, this.endColIdx - 1);
    }
}
