package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.annotation.ActorLog;
import com.ruanyuan.crm_master.pojo.Customer;
import com.ruanyuan.crm_master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Customer")
public class CustomerController {
    //注册客户业务类
    @Autowired
    private CustomerService customerService;

    //分页展示所有客户
    @GetMapping("/getAllCusts/{page}/{size}")
    public PageInfo<Customer> getAllCusts(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有部门方法
        List<Customer> allCustomer = customerService.getAllCustomer();
        PageInfo<Customer> custPageInfo = new PageInfo<Customer>(allCustomer);
        return custPageInfo;
    }

    @PostMapping("/getAllCusts/{page}/{size}")
    public PageInfo<Customer> showAllEmployee(@RequestBody @PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String custName) {
        PageHelper.startPage(pageNo, pageSize);
        List<Customer> allCustomer = customerService.getAllCustomer(custName);
        PageInfo<Customer> customerPageInfo = new PageInfo<Customer>(allCustomer);
        // 执行查询全部方法
        return customerPageInfo;
    }

    //展示所有用户
    @GetMapping("/getAllCusts")
    public List<Customer> getAllCusts() {
        //执行查询所有部门方法
        List<Customer> allCust = customerService.getAllCustomer();
        return allCust;
    }


    //添加客户
    @PostMapping("/addCustomer")
    public int addCustomer(Customer customer) {
        //格式化时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        customer.setCustCreatetime(date);
        //执行添加客户方法
        int i = customerService.addCustomer(customer);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }


    //删除客户方法
    @ActorLog("删除客户")
    @RequestMapping("/deleteCustomerById/{id}")
    public int deleteCustomerById(@PathVariable("id") Integer id) {
        //执行删除客户方法
        int i = customerService.deleteCustomer(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //批量删除客户信息
    @ActorLog("批量删除客户")
    @DeleteMapping("/delCustomers")
    public int delCustomers(Integer[] ids) {
        //执行批量删除方法
        int i = customerService.deleteMoreCustomer(ids);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id修改客户信息
    @ActorLog("修改客户")
    @PutMapping("/updateCustomer")
    public int updateCustomer(@RequestBody Customer customer) {
        //执行修改方法
        int i = customerService.updateCustomer(customer);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id查询客户信息
    @GetMapping("getCustomerById/{Id}")
    public Customer getCustomerById(@PathVariable("Id") Integer id) {
        return customerService.getCustomerById(id);
    }
}
