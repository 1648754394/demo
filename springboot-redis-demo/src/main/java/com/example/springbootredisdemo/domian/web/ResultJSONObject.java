package com.example.springbootredisdemo.domian.web;

import com.alibaba.fastjson.JSONObject;

import com.example.springbootredisdemo.constant.ErrorCodes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ResultJSONObject extends Result implements Serializable {

    private JSONObject data;

    public ResultJSONObject(JSONObject data) {
        this(ErrorCodes.SUCCESS, "success", data);
    }

    public ResultJSONObject(Result result, JSONObject data) {
        this(result.getCode(), result.getMessage(), data);
    }

    public ResultJSONObject(int code, String message, JSONObject data) {
        super(code, message);
        if (null == data) {
            data = new JSONObject();
        }
        this.data = data;
    }

}
