package com.ruanyuan.crm_master.controller;


import com.ruanyuan.crm_master.dao.TaskDao;
import com.ruanyuan.crm_master.pojo.Task;
import com.ruanyuan.crm_master.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TaskControllerTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void test() {
        List<Task> allTask = taskService.getAllTask("a",null,null,null,null);
        System.out.println(allTask);
    }

}