package com.ruanyuan.crm_master.service.impl;

import com.github.pagehelper.Page;
import com.ruanyuan.crm_master.dao.EmployeeDao;
import com.ruanyuan.crm_master.pojo.Customer;
import com.ruanyuan.crm_master.pojo.Employee;
import com.ruanyuan.crm_master.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 员工业务接口实现类
 *
 * @author zbp
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    // 注册员工方法接口
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 员工登录
     */
    @Override
    public Employee getLogin(Employee emp) {
        // TODO Auto-generated method stub
        return employeeDao.getLogin(emp);
    }

    /**
     * 员工注册
     */
    @Override
    public int addEmployee(Employee emp) {
        // TODO Auto-generated method stub
        return employeeDao.addEmployee(emp);
    }

    /**
     * 删除员工
     */
    @Override
    public int deleteEmployee(int id) {
        // TODO Auto-generated method stub
        return employeeDao.deleteEmployee(id);
    }

    /**
     * 修改员工
     */
    @Override
    public int updateEmployee(Employee Employee) {
        // TODO Auto-generated method stub
        return employeeDao.updateEmployee(Employee);
    }

    /**
     * 多条件查询员工信息
     *
     * @param empName   员工姓名
     * @param account   员工账号
     * @param empRoleId 角色id
     * @param empDeptId 部门id
     * @return 员工信息集合
     */
    @Override
    public List<Employee> getAllEmployee(String empName, String account, Integer empRoleId, Integer empDeptId) {
        System.out.println(empName + "," + account + "," + empRoleId + "," + empDeptId);
        return employeeDao.getAllEmployee(empName, account, empRoleId, empDeptId);
    }


    /**
     * 查询所有员工信息
     *
     * @return 员工信息集合
     */
    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    /**
     * 根据id查询员工信息
     *
     * @param id 员工id
     * @return 员工实体类对象
     */
    @Override
    public Employee getEmpById(int id) {
        return employeeDao.getEmpById(id);
    }

    /**
     * 批量删除
     *
     * @param emps 员工id集合
     * @return 影响的行数
     */
    public int deleteMoreEmp(Integer[] emps) {
        return employeeDao.deleteMoreEmp(emps);
    }


    /**
     * 根据员工姓名查询员工信息
     *
     * @param empName 员工名
     * @return 员工信息
     */
    public Employee getEmployeeByName(String empName) {
        return employeeDao.getEmployeeByName(empName);
    }
}
