package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.pojo.Customer;
import com.ruanyuan.crm_master.service.CustomerService;
import com.ruanyuan.crm_master.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Customer")
public class CustomerController {
    //注册客户业务类
    @Autowired
    private CustomerService customerService;
    //注册员工业务类
    @Autowired
    private EmployeeService employeeService;

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
    public PageInfo<Customer> showAllEmployee(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String custName) {
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
        System.out.println(allCust);
        return allCust;
    }


    //添加客户
    @PostMapping("/addCustomer")
    public int addCustomer(Customer customer) {
        System.out.println("99999999");
        System.out.println(customer);
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

    //根据客户名查询客户信息
//    @RequestMapping("/getEmpByName")
//    public int getEmpByName(@RequestBody String employee) {
//        System.out.println("empName:" + employee);
//        //执行根据用户姓名查询用户信息
//        Employee employeeByName = employeeService.getEmployeeByName(employee);
//        //判断是否存在用户信息
//        if (employeeByName != null) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }

    //删除客户方法
    @RequestMapping("/deleteCustomerById/{id}")
    public int deleteCustomerById(@PathVariable("id") Integer id) {
        System.out.println("custId" + id);
        //执行删除客户方法
        int i = customerService.deleteCustomer(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //批量删除客户信息
    @DeleteMapping("/delCustomers")
    public int delCustomers(Integer[] ids) {
        System.out.println(ids);
        //执行批量删除方法
        int i = customerService.deleteMoreCustomer(ids);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id修改客户信息
    @PutMapping("/updateCustomer")
    public int updateCustomer(@RequestBody Customer customer) {
        //执行修改方法
        int i = customerService.updateCustomer(customer);
        if (i > 0) {
            System.out.println(i);
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
