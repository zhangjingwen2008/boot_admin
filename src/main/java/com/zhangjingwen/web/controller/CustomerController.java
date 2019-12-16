package com.zhangjingwen.web.controller;

import com.zhangjingwen.common.response.ResponseResult;
import com.zhangjingwen.pojo.Customer;
import com.zhangjingwen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Customer customer) {
        return customerService.add(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseResult delete(@PathVariable("customerId") int customerId) {
        return customerService.delete(customerId);
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @GetMapping("/get/{customerId}")
    public ResponseResult get(@PathVariable("customerId") int customerId) {
        return customerService.get(customerId);
    }

    @GetMapping("/list/{start}/{size}")
    public ResponseResult list(@PathVariable("start") int start,
                               @PathVariable("size") int size) {
        return customerService.list(start, size);
    }

    @GetMapping("/listByGrade/{grade}/{start}/{size}")
    public ResponseResult list(@PathVariable("grade") String grade,
                               @PathVariable("start") int start,
                               @PathVariable("size") int size) {
        return customerService.listByGrade(start, size, grade);
    }

}
