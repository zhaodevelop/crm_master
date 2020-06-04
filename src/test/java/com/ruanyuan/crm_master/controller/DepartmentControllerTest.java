package com.ruanyuan.crm_master.controller;

import com.ruanyuan.crm_master.dao.DepartmentDao;
import com.ruanyuan.crm_master.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.util.resources.cldr.rof.CurrencyNames_rof;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentControllerTest {
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void test() {
        List<Department> allDept = departmentDao.getAllDept("人");
        System.out.println(allDept);
    }

    @Test
    public void test1() {
        Department department = new Department();
        department.setDeptName("haha");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        department.setDeptTime(date);
        department.setDeptRemark("haha");
        int i = departmentDao.addDept(department);
        System.out.println(i);
    }

    @Test
    public void test2() {
        int i = departmentDao.deleteDept(6);
        if (i > 0)
            System.out.println("删除成功");
    }

    @Test
    public void test3() {
        Department department = new Department();
        department.setDeptId(1);
        department.setDeptRemark("asdsadsad");
        department.setDeptName("asdsadsad");
        int i = departmentDao.updateDept(department);
        if (i > 0) {
            System.out.println("修改成功");
        }
    }

    @Test
    public void test4() {
        Department dept = departmentDao.getDeptById(1);
        System.out.println(dept);
    }

}