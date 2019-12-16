package com.zhangjingwen.service;

import com.zhangjingwen.common.response.Response;
import com.zhangjingwen.common.response.ResponseResult;
import com.zhangjingwen.pojo.Customer;
import org.json.JSONException;
import org.springframework.stereotype.Service;

public interface CustomerService {
    //新增客户
    ResponseResult add(Customer customer);

    //删除客户
    ResponseResult delete(int customerId);

    //修改客户
    ResponseResult update(Customer customer);

    //根据Id查询客户
    ResponseResult get(int customerId) ;

    //客户列表
    ResponseResult list(int start, int size);

    //根据等级筛选客户
    ResponseResult listByGrade(int start, int size, String garde);

}
