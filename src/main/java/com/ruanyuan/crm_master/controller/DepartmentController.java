package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.pojo.Department;
import com.ruanyuan.crm_master.pojo.Employee;
import com.ruanyuan.crm_master.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //分页展示所有部门
    @GetMapping("/getAllDepts/{page}/{size}")
    public PageInfo<Department> getAllDepts(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有部门方法
        List<Department> allDept = departmentService.getAllDept();
        PageInfo<Department> deptPageInfo = new PageInfo<Department>(allDept);
        return deptPageInfo;
    }

    @PostMapping("/getAllDepts/{page}/{size}")
    public PageInfo<Department> getAllDepts(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String deptName) {
        System.out.println("9999999999999999999999999999999");
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有部门方法
        List<Department> allDept = departmentService.getAllDept(deptName);
        PageInfo<Department> deptPageInfo = new PageInfo<Department>(allDept);
        return deptPageInfo;
    }

    //展示所有部门信息
    @GetMapping("/getAllDepts")
    public List<Department> getAllDept() {
        //执行查询所有部门方法
        List<Department> allDept = departmentService.getAllDept();
        return allDept;
    }

    //添加部门信息
    @PostMapping("/addDept")
    public int addDept(@RequestBody Department dept) {
        //格式化时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        dept.setDeptTime(date);
        //执行添加部门方法
        int i = departmentService.addDept(dept);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //删除部门信息
    @RequestMapping("/deleteDeptById/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id) {
        int i = departmentService.deleteDept(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //修改部门信息
    @PutMapping("/updateDept")
    public int updateDept(@RequestBody Department department) {
        int i = departmentService.updateDept(department);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id查询部门信息
    @RequestMapping("/getDeptById/{id}")
    public Department getDeptById(@PathVariable("id") Integer id) {
        Department dept = departmentService.getDeptById(id);
        return dept;
    }

    //批量删除部门信息
    @DeleteMapping("/delDepts")
    public int delDepts(Integer[] ids) {
        //截取字符串
        int i = departmentService.deleteMoreDept(ids);
        if (i > 0) {
            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqq");
            System.out.println(i);
            System.out.println(i);
            return 1;
        } else {
            return 0;
        }
    }

}
