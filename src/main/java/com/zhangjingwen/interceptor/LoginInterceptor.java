package com.zhangjingwen.interceptor;

import com.zhangjingwen.common.exception.ExceptionCast;
import com.zhangjingwen.common.exception.code.UserCode;
import com.zhangjingwen.dao.UserMapper;
import com.zhangjingwen.pojo.User;
import com.zhangjingwen.service.CustomerService;
import com.zhangjingwen.service.UserService;
import com.zhangjingwen.service.impl.UserServiceImpl;
import com.zhangjingwen.web.utils.TimeAndDateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //跨域配置
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Headers","*");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        //访问白名单
        String uri = request.getRequestURI();
        String page = StringUtils.remove(uri, "/api/");
        String[] notRequireAuthPages = new String[]{"user"};
        if (startWith(page, notRequireAuthPages)) {
            return true;
        }

        //判断登录信息是否正确
        User user = userService.getUser();
        if (null == user) {
            ExceptionCast.cast(UserCode.USER_NOT_EXIST);
        }
        //判断timeout过期
        long timeout = user.getTimeout();
        long now = TimeAndDateUtils.getTimestamp();
        if (now > timeout) {
            ExceptionCast.cast(UserCode.USER_TIMEOUT);
        }

        return true;
    }

    private boolean startWith(String page,String[] requiredAuthPages){
        for (String str : requiredAuthPages) {
            if (StringUtils.startsWith(page, str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
