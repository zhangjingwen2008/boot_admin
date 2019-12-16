package com.zhangjingwen.dao;

import com.zhangjingwen.pojo.User;

public interface UserMapper {

    //注册帐户
    int add(User user);

    //修改帐户
    int update(User user);

    //根据token查询帐户
    User findByToken(String token);

    //根据username查询帐户
    User findByUsername(String username);

}
