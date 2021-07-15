package com.zhong.po;

/**
 * @author 华韵流风
 * @ClassName DataValiException
 * @Description TODO
 * @Date 2021/7/15 10:15
 * @packageName com.zhong.po
 */
public class DataValidException extends RuntimeException{

    public DataValidException(String message) {
        super(message);
    }
}
