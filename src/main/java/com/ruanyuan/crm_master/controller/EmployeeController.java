package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.annotation.ActorLog;
import com.ruanyuan.crm_master.pojo.Employee;
import com.ruanyuan.crm_master.pojo.LoginLog;
import com.ruanyuan.crm_master.service.EmployeeService;
import com.ruanyuan.crm_master.service.LoginLogService;
import com.ruanyuan.crm_master.utils.IpUtils;
import com.ruanyuan.crm_master.utils.MD5;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
    //注入登录日志业务层
    @Autowired
    private LoginLogService loginLogService;

    // 员工登录
    @PostMapping("/login")
    private int getlogin(Employee emp, HttpSession session, HttpServletRequest request) throws UnknownHostException, UnsupportedEncodingException {
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
            //获取请求ip地址
            String ipAddr = IpUtils.getIpAddr(request);
            //根据ip地址查询ip所在地
            String address = IpUtils.getIpInfo(ipAddr);
            //将登陆对象传入session
            session.setAttribute("employee", employee);
            //实例化登录日志实体类
            LoginLog loginLog = new LoginLog();
            //获取员工登录账号id
            int empId = employee.getEmpId();
            //实例化员工
            Employee employee1 = new Employee();
            employee1.setEmpId(empId);
            loginLog.setEmployee(employee1);
            loginLog.setLogIp(ipAddr);
            //获取系统当前时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());
            loginLog.setLogTime(date);
            if (address != "" && address != null) {
                loginLog.setLogaddr(address);
            }
            //添加登录日志信息
            int i = loginLogService.addLoginLog(loginLog);
            return 1;
        }
        return 0;
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

    // 多条件查询员工信息
    @PostMapping("/allEmps/{page}/{size}")
    public PageInfo<Employee> showAllEmployee(@RequestBody @PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String empName, String account, Integer empRoleId, Integer empDeptId) {
        //定义分页格式
        PageHelper.startPage(pageNo, pageSize);
        // 执行查询所有员工方法
        List<Employee> allEmployee = employeeService.getAllEmployee(empName, account, empRoleId, empDeptId);
        PageInfo<Employee> employeePageInfo = new PageInfo<Employee>(allEmployee);
        return employeePageInfo;
    }

    //分页查询员工信息
    @GetMapping("/allEmps/{page}/{size}")
    public PageInfo<Employee> showAllEmployee1(@RequestBody @PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有员工方法
        List<Employee> allEmployee = employeeService.getAllEmployee();
        //对员工进行分页操作
        PageInfo<Employee> employeePageInfo = new PageInfo<Employee>(allEmployee);
        return employeePageInfo;
    }

    //查询所有员工信息
    @GetMapping("/allEmps")
    public List<Employee> showAllEmployee1() {
        //查询所有员工信息
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return allEmployee;
    }

    //根据ID删除员工信息
//    @ActorLog("删除员工信息")
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
//    @ActorLog("批量删除员工信息")
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
//    @ActorLog("修改员工信息")
    @PutMapping("/updateEmpById")
    public Integer updateEmpById(@RequestBody Employee emp) {
        //执行修改员工信息方法
        int i = employeeService.updateEmployee(emp);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
