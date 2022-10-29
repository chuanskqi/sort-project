package com.opencare.sort.controller.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class BaseResponse<T> implements Serializable {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    private T data;

    public static final int RESP_CODE_OK = 200;

    public static final String RESP_MESSAGE_OK = "success";

    public static final int RESP_CODE_FAIL = -1;

    public static final String RESP_MESSAGE_FAIL = "fail";

    public BaseResponse() {
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<T>(RESP_CODE_OK, RESP_MESSAGE_OK, null);
    }

    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<T>(RESP_CODE_OK, RESP_MESSAGE_OK, data);
    }

    public static <T> BaseResponse<T> fail(String msg) {
        return new BaseResponse<T>(RESP_CODE_FAIL, msg, null);
    }

    public static <T> BaseResponse<T> fail(int errorCode, String msg) {
        return new BaseResponse<T>(errorCode, msg, null);
    }

    public boolean success() {
        return this.code == RESP_CODE_OK;
    }

}
