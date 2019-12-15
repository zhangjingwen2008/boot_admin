package com.zhangjingwen.service.impl;

import com.zhangjingwen.common.exception.code.CommonCode;
import com.zhangjingwen.common.exception.code.CustomerCode;
import com.zhangjingwen.common.response.ResponseResult;
import com.zhangjingwen.dao.CustomerMapper;
import com.zhangjingwen.pojo.Customer;
import com.zhangjingwen.service.CustomerService;
import com.zhangjingwen.web.utils.TimeAndDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    //增加客户
    @Override
    public ResponseResult add(Customer customer) {
        //新增用户
        customer.setCreatetime(TimeAndDateUtils.getTimestamp());
        customer.setUpdatetime(TimeAndDateUtils.getTimestamp());
        int result = customerMapper.add(customer);
        if (result == 0) {
            return new ResponseResult(CustomerCode.CUSTOMER_ADD_FAIL);
        }

        return new ResponseResult(CommonCode.SUCCESS);
    }

    //删除客户
    @Override
    public ResponseResult delete(int customerId) {
        int result = customerMapper.delete(customerId);
        if (result == 0) {
            return new ResponseResult(CustomerCode.CUSTOMER_DELETE_FAIL);
        }

        return new ResponseResult(CommonCode.SUCCESS);
    }

    //更新客户
    @Override
    public ResponseResult update(Customer customer) {
        return null;
    }

    //根据id查找客户
    @Override
    public ResponseResult findById(int customerId) {
        return null;
    }

    //客户列表
    @Override
    public ResponseResult list(int start, int size) {
        return null;
    }
}
