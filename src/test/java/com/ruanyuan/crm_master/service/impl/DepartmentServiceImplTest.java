package com.ruanyuan.crm_master.service.impl;

import com.ruanyuan.crm_master.dao.DepartmentDao;
import com.ruanyuan.crm_master.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void test() {
        List<Department> person = departmentDao.getAllDept("人");
        System.out.println("person" + person);
    }

}