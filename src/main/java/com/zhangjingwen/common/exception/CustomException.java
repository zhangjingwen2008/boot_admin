package com.zhangjingwen.common.exception;

import com.zhangjingwen.common.response.ResultCode;

public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return this.resultCode;
    }

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
