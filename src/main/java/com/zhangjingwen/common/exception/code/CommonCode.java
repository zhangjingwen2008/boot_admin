package com.zhangjingwen.common.exception.code;

import com.zhangjingwen.common.response.ResultCode;
import lombok.ToString;

@ToString
public enum CommonCode implements ResultCode {

    SUCCESS(true, 1000, "操作成功!"),
    FAIL(false,1111,"操作失败！"),
    UNAUTHENTICATED(false,1001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,1002,"权限不足，无权操作！"),
    INVALID_PARAM(false,1003,"非法参数！"),
    SERVER_ERROR(false,9999,"抱歉，系统繁忙，请稍后重试！");

    boolean success;
    int code;
    String message;

    private CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
