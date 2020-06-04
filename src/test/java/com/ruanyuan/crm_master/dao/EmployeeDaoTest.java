package com.ruanyuan.crm_master.dao;

import com.ruanyuan.crm_master.pojo.Department;
import com.ruanyuan.crm_master.pojo.Employee;
import com.ruanyuan.crm_master.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private RoleDao roleDao;

    @Test
    void test1() {
        List<Employee> a = employeeDao.getAllEmployee();
        System.out.println(a);
    }

    @Test
    void test2() {
        Employee employee = new Employee();
        employee.setEmpName("a");
        employee.setAccount("113");
        employee.setPassword("123");
        employee.setEmpSex("男");
        employee.setEmpAddress("123");
        Role role = new Role();
        Department department = new Department();
        role.setRoleId(1);
        department.setDeptId(1);
        employee.setRole(role);
        employee.setDepartment(department);
        int i = employeeDao.addEmployee(employee);
        if (i > 0) {
            System.out.println("OK");
        }
    }

    @Test
    public void delete() {
//        int i = employeeDao.deleteEmployee(18);
        Employee emp = employeeDao.getEmpById(1);
        System.out.println(emp);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setEmpSex("女");
        Role role = new Role();
        role.setRoleId(1);
        employee.setRole(role);
        employee.setEmpId(30);
        int i = employeeDao.updateEmployee(employee);
        if (i > 0) {
            System.out.println("更新成功！");
        }
    }

    @Test
    public void like() {

    }


}