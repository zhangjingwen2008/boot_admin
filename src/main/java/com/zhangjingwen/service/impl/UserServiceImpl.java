package com.zhangjingwen.service.impl;

import com.mysql.cj.util.StringUtils;
import com.zhangjingwen.common.exception.code.CommonCode;
import com.zhangjingwen.common.exception.code.CustomerCode;
import com.zhangjingwen.common.exception.code.UserCode;
import com.zhangjingwen.common.response.DataResult;
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
        //判断参数
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || password == null) {
            return ResponseResult.FAIL();
        }

        //获得用户对象
        User findByUsername = userMapper.findByUsername(username);
        if (null == findByUsername) {
            return new DataResult(CommonCode.FAIL, UserCode.USER_NOT_EXIST);
        }

        //用户验证
        String salt = findByUsername.getSalt();
        String corretPassword = findByUsername.getPassword();
        String encryPassword = EncryptionUtils.md5Hex(password + salt);
        if (!encryPassword.equals(corretPassword)) {
            return new DataResult(CommonCode.FAIL, UserCode.USER_LOGIN_FAIL);
        }

        //设置登录信息
        String timestamp = TimeAndDateUtils.getTimestamp() + "";
        Random random = new Random();
        int randomNum = random.nextInt(8999) + 1000;
        String token = EncryptionUtils.md5Hex(timestamp + randomNum);       //构造Token
        long timeout = TimeAndDateUtils.getAfterTime(15);                   //构造timeout

        //更新进数据库
        User newUser = new User();
        newUser.setUserId(findByUsername.getUserId());
        newUser.setToken(token);
        newUser.setTimeout(timeout);
        newUser.setUpdatetime(TimeAndDateUtils.getTimestamp());
        int result = userMapper.update(newUser);
        if (result == 0) {
            return new ResponseResult(CommonCode.FAIL);
        }

        return new DataResult<>(CommonCode.SUCCESS, token);
    }
}
