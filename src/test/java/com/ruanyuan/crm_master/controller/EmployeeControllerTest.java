package com.ruanyuan.crm_master.controller;

import com.ruanyuan.crm_master.dao.EmployeeDao;
import com.ruanyuan.crm_master.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeControllerTest {
    //注入dao接口
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void test() {
        Employee empById = employeeDao.getEmpById(1);
        System.out.println(empById);
    }
}