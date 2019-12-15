package com.zhangjingwen.common.exception.code;

import com.zhangjingwen.common.response.ResultCode;

public enum UserCode implements ResultCode {
    USER_LOGIN_FAIL(false, 2001, "账户名或密码错误");

    boolean success;
    int code;
    String message;

    private UserCode(boolean success, int code, String message) {
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
