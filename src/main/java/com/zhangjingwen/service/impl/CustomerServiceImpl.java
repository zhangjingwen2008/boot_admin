package com.zhangjingwen.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import com.zhangjingwen.common.exception.code.CommonCode;
import com.zhangjingwen.common.exception.code.CustomerCode;
import com.zhangjingwen.common.response.DataPageResult;
import com.zhangjingwen.common.response.DataResult;
import com.zhangjingwen.common.response.ResponseResult;
import com.zhangjingwen.dao.CustomerMapper;
import com.zhangjingwen.pojo.Customer;
import com.zhangjingwen.service.CustomerService;
import com.zhangjingwen.web.utils.TimeAndDateUtils;
import org.json.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        customer.setUpdatetime(TimeAndDateUtils.getTimestamp());
        int result = customerMapper.update(customer);
        if (result == 0) {
            return new ResponseResult(CustomerCode.CUSTOMER_UPDATE_FAIL);
        }

        return new ResponseResult(CommonCode.SUCCESS);
    }

    //根据id查找客户
    @Override
    public ResponseResult get(int customerId)  {
        Customer customer = customerMapper.findById(customerId);
        if (null == customer) {
            return new ResponseResult(CustomerCode.CUSTOMER_NOT_EXIST);
        }

        //拼装数据
        JSONObject data = new JSONObject();
        data.put("customerId", customer.getCustomerId());
        data.put("customerName", customer.getCustomerName());
        data.put("customerPhone", customer.getCustomerPhone());
        data.put("grade", customer.getGrade());
        data.put("createTime", TimeAndDateUtils.getDateFromTimestamp(customer.getCreatetime()));

        return new DataResult<>(CommonCode.SUCCESS, data);
    }

    //客户列表
    @Override
    public ResponseResult list(int start, int size) {
        if (start < 1) {
            start = 1;
        }
        if (size == 0) {
            size = 10;
        }
        PageHelper.startPage(start, size);
        Page<Customer> page = customerMapper.list();

        JSONArray list = new JSONArray();
        for (Customer customer : page) {
            JSONObject data = new JSONObject();
            data.put("customerId", customer.getCustomerId());
            data.put("customerName", customer.getCustomerName());
            data.put("customerPhone", customer.getCustomerPhone());
            data.put("grade", customer.getGrade());
            data.put("createTime", TimeAndDateUtils.getDateFromTimestamp(customer.getCreatetime()));
            list.add(data);
        }

        return new DataPageResult(CommonCode.SUCCESS, page, list);
    }

    //根据等级筛选客户
    @Override
    public ResponseResult listByGrade(int start, int size, String grade) {
        if (start < 1) {
            start = 1;
        }
        if (size < 0) {
            size = 10;
        }
        PageHelper.startPage(start, size);
        Page<Customer> page = customerMapper.listByGrade(grade);

        JSONArray list = new JSONArray();
        for (Customer customer : page) {
            JSONObject data = new JSONObject();
            data.put("customerId", customer.getCustomerId());
            data.put("customerName", customer.getCustomerName());
            data.put("customerPhone", customer.getCustomerPhone());
            data.put("grade", customer.getGrade());
            data.put("createTime", TimeAndDateUtils.getDateFromTimestamp(customer.getCreatetime()));
            list.add(data);
        }

        return new DataPageResult(CommonCode.SUCCESS, page, list);
    }
}
