package com.zhangjingwen.dao;

import com.zhangjingwen.pojo.User;

public interface UserMapper {

    //注册帐户
    int add(User user);

    //根据token查询帐户
    User findByToken(String token);

}
