package com.ruanyuan.crm_master.service.impl;

import com.ruanyuan.crm_master.dao.CustomerDao;
import com.ruanyuan.crm_master.pojo.Customer;
import com.ruanyuan.crm_master.pojo.Department;
import com.ruanyuan.crm_master.pojo.Employee;
import com.ruanyuan.crm_master.pojo.Role;
import com.ruanyuan.crm_master.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void test() {
        Customer customer = new Customer();
        Employee employee = new Employee();
        employee.setEmpId(1);
        customer.setCustName("asd");
        customer.setEmployee(employee);
//        role.setRoleName("asd");
//        employee.setRole(role);
//        customer.setEmployee(employee);
//
//        Department department = new Department();
//        department.setDeptName("asd");
//        employee.setDepartment(department);
        int i = customerDao.addCustomer(customer);
        System.out.println(i);
    }

}