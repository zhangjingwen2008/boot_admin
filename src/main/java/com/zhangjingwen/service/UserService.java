package com.zhangjingwen.service;

import com.zhangjingwen.common.response.ResponseResult;
import com.zhangjingwen.pojo.User;

public interface UserService {
    //注册账号
    ResponseResult register(User user);

    //登录
    ResponseResult login(User user);

    //根据Token获取当前对象
    User getUser();
}
