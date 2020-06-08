package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.pojo.Employee;
import com.ruanyuan.crm_master.service.EmployeeService;
import com.ruanyuan.crm_master.utils.MD5;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 员工管理控制器
 *
 * @author zbp
 */
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    // 注册员工业务层
    @Autowired
    private EmployeeService employeeService;

    // 跳转至登录页面
    @RequestMapping("/tologin")
    private String login() {
        return "login";
    }

    // 员工登录
    @RequestMapping("/login")
    private int getlogin(Employee emp, HttpSession session) {
        // 获取账号信息
        String account = emp.getAccount();
        // 获取密码信息
        String password = emp.getPassword();
        // md5加密
        String md5Pwd = MD5.MD5Encode(password);
        emp.setPassword(md5Pwd);
        // 调用登录方法
        Employee employee = employeeService.getLogin(emp);
        // 登录成功
        if (employee != null) {
            session.setAttribute("employee", employee);
            return 1;
        } else {
            return 0;
        }

    }

    //员工注册
    @PostMapping("/addEmployee")
    public int addEmployee(Employee emp) {
        //格式化时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        //为员工添加入职时间
        emp.setEmpWorkTime(date);
        //执行添加员工方法
        int sign = employeeService.addEmployee(emp);
        if (sign > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // 展示所有员工信息
    @PostMapping("/allEmps/{page}/{size}")
    public PageInfo<Employee> showAllEmployee(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String empName, String account, String empRoleId, String empDeptId) {
        System.out.println("999999999999999999999999999");
        PageHelper.startPage(pageNo, pageSize);
        List<Employee> allEmployee = employeeService.getAllEmployee(empName, account, Integer.parseInt(empRoleId), Integer.parseInt(empDeptId));
        PageInfo<Employee> employeePageInfo = new PageInfo<Employee>(allEmployee);
        // 执行查询全部方法
        return employeePageInfo;
    }

    @GetMapping("/allEmps/{page}/{size}")
    public PageInfo<Employee> showAllEmployee1(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Employee> allEmployee = employeeService.getAllEmployee();
        PageInfo<Employee> employeePageInfo = new PageInfo<Employee>(allEmployee);
        // 执行查询全部方法
        return employeePageInfo;
    }

    @GetMapping("/allEmps")
    public List<Employee> showAllEmployee1() {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return allEmployee;
    }

    //根据ID删除员工信息
    @RequestMapping("/deleteById/{Id}")
    public Integer deleteById(@PathVariable("Id") Integer id) {
        int i = employeeService.deleteEmployee(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //批量删除员工信息
    @DeleteMapping("/delEmps")
    public int deleteEmps(Integer[] ids) {
        //截取字符串
        int i = employeeService.deleteMoreEmp(ids);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id查询员工信息
    @GetMapping("getEmpById/{Id}")
    public Employee getEmpById(@PathVariable("Id") Integer id) {
        return employeeService.getEmpById(id);
    }

    //根据id修改员工信息
    @PutMapping("/updateEmpById")
    public Integer updateEmpById(@RequestBody Employee emp) {
        int i = employeeService.updateEmployee(emp);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
