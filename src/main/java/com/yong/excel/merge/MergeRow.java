package com.yong.excel.merge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by lichking on 2017. 7. 16..
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MergeRow {
    private int colIdx;
    private int startRowIdx;
    private int endRowIdx;

    public static class Builder{
        private int colIdx;
        private int startRowIdx;
        private int endRowIdx;

        public Builder colIdx(int colIdx){
            this.colIdx = colIdx;

            return this;
        }

        public Builder startRowIdx(int startRowIdx){
            this.startRowIdx = startRowIdx;

            return this;
        }

        public Builder endRowIdx(int endRowIdx){
            this.endRowIdx = endRowIdx;

            return this;
        }

        public MergeRow build(){
            return new MergeRow(this.colIdx, this.startRowIdx, this.endRowIdx);
        }
    }
}
