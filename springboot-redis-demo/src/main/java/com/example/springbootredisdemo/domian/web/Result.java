package com.example.springbootredisdemo.domian.web;

import com.alibaba.fastjson.JSON;
import com.example.springbootredisdemo.constant.ErrorCodes;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author benqio
 */
@Setter
@Getter
public class Result implements Serializable {

    public static final Result SUCCESS = new Result(ErrorCodes.SUCCESS, "success");

    public static final Result ERROR = new Result(ErrorCodes.ERROR, "error");

    private int code;

    private String message;

    public Result() {
    }

    public Result(String message) {
        this(ErrorCodes.ERROR, message);
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
