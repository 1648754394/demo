package com.example.springbootredisdemo.domian.web;


import com.example.springbootredisdemo.constant.ErrorCodes;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author benqio
 */
@Setter
@Getter
public class ResultData<T> extends Result implements Serializable {

    private T data;

    public ResultData() {}

    public ResultData(T data) {
        this(ErrorCodes.SUCCESS, "success", data);
    }

    public ResultData(Result result, T data) {
        this(result.getCode(), result.getMessage(), data);
    }

    public ResultData(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

}
