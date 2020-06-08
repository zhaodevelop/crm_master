package com.ruanyuan.crm_master.controller;

import com.ruanyuan.crm_master.dao.EmployeeDao;
import com.ruanyuan.crm_master.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeControllerTest {
    //注入dao接口
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void test() {
        List<Employee> a = employeeDao.getAllEmployee(null, null, 1, null);
        System.out.println(a);
    }
}