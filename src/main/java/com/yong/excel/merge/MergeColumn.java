package com.yong.excel.merge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by lichking on 2017. 7. 16..
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MergeColumn implements Mergeable {
    private int rowIdx;
    private int startColIdx;
    private int endColIdx;

    @Override
    public MergeRange getMergeRange() {
        return new MergeRange(this.rowIdx, this.rowIdx, this.startColIdx, this.endColIdx - 1);
    }

    public static class Builder{
        private int rowIdx;
        private int startColIdx;
        private int endColIdx;

        public Builder rowIdx(int rowIdx){
            this.rowIdx = rowIdx;

            return this;
        }

        public Builder startColIdx(int startColIdx){
            this.startColIdx = startColIdx;

            return this;
        }

        public Builder endColIdx(int endColIdx){
            this.endColIdx = endColIdx;

            return this;
        }

        public MergeColumn build(){
            return new MergeColumn(this.rowIdx, this.startColIdx, this.endColIdx);
        }
    }
}
