package com.zhangjingwen.dao;

import com.github.pagehelper.Page;
import com.zhangjingwen.pojo.Customer;

public interface CustomerMapper {

    //新增客户
    int add(Customer customer);

    //删除客户
    int delete(int customerId);

    //修改客户
    int update(Customer customer);

    //根据Id查询客户
    Customer findById(int customerId);

    //分页查询客户列表
    Page<Customer> list();

    //根据客户等级筛选客户
    Page<Customer> listByGrade(String grade);

}
