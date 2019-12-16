package com.zhangjingwen.common.exception.code;

import com.zhangjingwen.common.response.ResultCode;

public enum CustomerCode implements ResultCode {
    CUSTOMER_ADD_FAIL(false,3001,"增加客户失败"),
    CUSTOMER_DELETE_FAIL(false,3002,"删除客户失败"),
    CUSTOMER_UPDATE_FAIL(false,3003,"更新用户失败"),
    CUSTOMER_NOT_EXIST(false,3004,"客户不存在");

    boolean success;
    int code;
    String message;

    CustomerCode(boolean success, int code, String message) {
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
