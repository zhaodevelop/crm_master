package com.ruanyuan.crm_master.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.ruanyuan.crm_master.pojo.Customer;
import com.ruanyuan.crm_master.pojo.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * 员工接口类
 *
 * @author zbp
 */
public interface EmployeeDao {
    /**
     * 员工登录
     *
     * @param emp 员工实体类对象
     * @return 员工实体类对象
     */
    public Employee getLogin(Employee emp);

    /**
     * 员工注册
     *
     * @param emp 员工实体类对象
     * @return 影响的行数
     */
    public int addEmployee(Employee emp);

    /**
     * 删除员工
     *
     * @param id
     * @return 影响的行数
     */
    public int deleteEmployee(int id);

    /**
     * 修改员工
     *
     * @param Employee
     * @return 影响的行数
     */
    public int updateEmployee(Employee Employee);


    /**
     * 多条件获取所有员工
     *
     * @return 分页后员工信息
     */
    public List<Employee> getAllEmployee(String empName, String account, Integer roleId, Integer deptId);

    /**
     * 获取所有员工
     *
     * @return 员工信息集合
     */
    public List<Employee> getAllEmployee();

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return 员工实体类对象
     */
    public Employee getEmpById(int id);

    /**
     * 批量删除员工
     *
     * @param empList 员工id集合
     */
    public int deleteMoreEmp(Integer[] empList);

    /**
     * 根据员工姓名查询员工信息
     *
     * @param employeeName 员工名
     * @return 客户信息
     */
    public Employee getEmployeeByName(String employeeName);
}
