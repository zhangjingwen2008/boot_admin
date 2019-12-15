package com.zhangjingwen.service.impl;

import com.mysql.cj.util.StringUtils;
import com.zhangjingwen.common.exception.code.CustomerCode;
import com.zhangjingwen.common.response.ResponseResult;
import com.zhangjingwen.dao.UserMapper;
import com.zhangjingwen.pojo.Customer;
import com.zhangjingwen.pojo.User;
import com.zhangjingwen.service.UserService;
import com.zhangjingwen.web.utils.EncryptionUtils;
import com.zhangjingwen.web.utils.TimeAndDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseResult register(User user) {
        //判断参数非空
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || password == null) {
            return ResponseResult.FAIL();
        }

        //盐加密
        Random random = new Random();
        int salt = random.nextInt(90) + 10;
        String encryPassword = EncryptionUtils.md5Hex(password + salt);
        user.setPassword(encryPassword);
        user.setSalt(salt + "");
        user.setCreatetime(TimeAndDateUtils.getTimestamp());
        user.setUpdatetime(TimeAndDateUtils.getTimestamp());

        //插入数据库
        int result = userMapper.add(user);
        if (result == 0) {
            return ResponseResult.FAIL();
        }

        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult login(User user) {
        return null;
    }
}
