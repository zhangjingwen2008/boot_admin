package com.zhangjingwen.service.impl;

import com.zhangjingwen.common.response.ResponseResult;
import com.zhangjingwen.dao.CustomerMapper;
import com.zhangjingwen.pojo.Customer;
import com.zhangjingwen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public ResponseResult add(Customer customer) {
        return null;
    }

    @Override
    public ResponseResult delete(int customerId) {
        return null;
    }

    @Override
    public ResponseResult update(Customer customer) {
        return null;
    }

    @Override
    public ResponseResult findById(int customerId) {
        return null;
    }

    @Override
    public ResponseResult list(int start, int size) {
        return null;
    }
}
