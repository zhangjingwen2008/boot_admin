package com.zhangjingwen.common.response;

public interface ResultCode {
    boolean success();

    int code();

    String message();
}
