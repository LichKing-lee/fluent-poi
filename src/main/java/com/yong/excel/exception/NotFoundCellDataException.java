package com.yong.excel.exception;

/**
 * Created by lichking on 2017. 7. 15..
 */
public class NotFoundCellDataException extends RuntimeException {
    public NotFoundCellDataException(){

    }

    public NotFoundCellDataException(String message){
        super(message);
    }
}
