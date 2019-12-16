package com.zhangjingwen.common.exception;

import com.zhangjingwen.common.response.ResultCode;

public class ExceptionCast {
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
