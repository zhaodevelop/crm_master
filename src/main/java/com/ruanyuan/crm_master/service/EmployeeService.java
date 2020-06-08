package com.ruanyuan.crm_master.service;

import com.ruanyuan.crm_master.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 员工业务类
 *
 * @author zbp
 */
public interface EmployeeService {
    /**
     * 员工登录
     *
     * @param emp 员工实体类对象
     * @return 员工实体类对象
     */
    public Employee getLogin(Employee emp);

    /**
     * 员工注册方法
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
     * 多条件查询员工信息
     *
     * @param empName     员工姓名
     * @param account     员工账号
     * @param empWorkTime 入职时间开始
     * @param endTime     入职时间结束
     * @param empRoleId   角色id
     * @param empDeptId   部门id
     * @return 员工信息集合
     */
    public List<Employee> getAllEmployee(@Param("empName") String empName, @Param("account") String account, @Param("empRoleId") Integer empRoleId, @Param("empDeptId") Integer empDeptId);

    /**
     * 分页查询所有员工信息
     *
     * @return 员工信息集合
     */
    public List<Employee> getAllEmployee();

    /**
     * 根据id查询员工信息
     *
     * @param id 员工id
     * @return 员工实体类对象
     */
    public Employee getEmpById(int id);

    /**
     * 批量删除员工信息
     *
     * @param emps 员工id集合
     */
    public int deleteMoreEmp(Integer[] emps);

    /**
     * 根据员工姓名查询员工信息
     *
     * @param empName 员工名
     * @return 员工信息
     */
    public Employee getEmployeeByName(String empName);


}

