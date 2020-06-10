package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.pojo.Task;
import com.ruanyuan.crm_master.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Task")
public class TaskController {
    //注入任务业务层
    @Autowired
    private TaskService taskService;

    //分页展示所有任务信息
    @GetMapping("/getAllTasks/{page}/{size}")
    public PageInfo<Task> getAllTasks(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有部门方法
        List<Task> allTasks = taskService.getAllTask();
        PageInfo<Task> taskPageInfo = new PageInfo<Task>(allTasks);
        return taskPageInfo;
    }


    //多条件查询任务信息
    @PostMapping("/getMoreAllTasks/{page}/{size}")
    public PageInfo<Task> getAllTasks(@RequestBody @PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String taskTitle, String taskState, String taskBuilder, String startTime, String endTime) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有部门方法
        List<Task> allTasks = taskService.getAllTask(taskTitle, taskState, taskBuilder, startTime, endTime);
        PageInfo<Task> interPageInfo = new PageInfo<Task>(allTasks);
        return interPageInfo;
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks() {
        //执行查询所有部门方法
        List<Task> allTasks = taskService.getAllTask();
        return allTasks;
    }

    //删除任务记录方法
    @RequestMapping("/deleteTask/{id}")
    public int deleteTask(@PathVariable("id") Integer id) {
        //执行删除任务方法
        int i = taskService.deleteTask(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //批量删除任务信息`
    @DeleteMapping("/delTasks")
    public int delTasks(Integer[] ids) {
        //执行批量删除方法
        int i = taskService.deleteMoreTask(ids);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //添加任务信息方法
    @PostMapping("/addTask")
    public int addTask(Task task) {
        //执行添加任务信息方法
        int sign = taskService.addTask(task);
        //判断执行情况
        if (sign > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id修改客户信息
    @PutMapping("/updateTask")
    public int updateTask(@RequestBody Task task) {
        //执行修改方法
        int i = taskService.updateTask(task);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}

