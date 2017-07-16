package com.yong.excel.merge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by lichking on 2017. 7. 16..
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Merge implements Mergeable {
    private int startRowIdx;
    private int endRowIdx;
    private int startColIdx;
    private int endColIdx;

    @Override
    public MergeRange getMergeRange() {
        return new MergeRange(this.startRowIdx, this.endRowIdx, this.startColIdx, this.endColIdx);
    }

    public static class Builder{
        private int startRowIdx;
        private int endRowIdx;
        private int startColIdx;
        private int endColIdx;

        public Merge.Builder startColIdx(int startColIdx){
            this.startColIdx = startColIdx;

            return this;
        }

        public Merge.Builder endColIdx(int endColIdx){
            this.endColIdx = endColIdx;

            return this;
        }

        public Merge.Builder startRowIdx(int startRowIdx){
            this.startRowIdx = startRowIdx;

            return this;
        }

        public Merge.Builder endRowIdx(int endRowIdx){
            this.endRowIdx = endRowIdx;

            return this;
        }

        public Merge build(){
            return new Merge(this.startRowIdx, this.endRowIdx, this.startColIdx, this.endColIdx);
        }
    }
}
