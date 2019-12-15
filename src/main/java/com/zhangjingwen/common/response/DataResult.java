package com.zhangjingwen.common.response;

public class DataResult<T> extends ResponseResult {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DataResult(ResultCode resultCode,T data) {
        super(resultCode);
        this.data = data;
    }
}
