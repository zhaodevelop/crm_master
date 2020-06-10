package com.ruanyuan.crm_master.service.impl;

import com.ruanyuan.crm_master.dao.TaskDao;
import com.ruanyuan.crm_master.pojo.Task;
import com.ruanyuan.crm_master.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author zbp
 */
@Service
public class TaskServiceImpl implements TaskService {
    // 注册任务方法接口
    @Autowired
    private TaskDao taskDao;

    /**
     * 添加任务信息
     */
    @Override
    public int addTask(Task task) {
        // TODO Auto-generated method stub
        return taskDao.addTask(task);
    }

    /**
     * 删除任务信息
     */
    @Override
    public int deleteTask(int id) {
        // TODO Auto-generated method stub
        return taskDao.deleteTask(id);
    }

    /**
     * 修改任务信息
     */
    @Override
    public int updateTask(Task task) {
        // TODO Auto-generated method stub
        return taskDao.updateTask(task);
    }

    /**
     * 查询所有任务信息
     *
     * @return 任务信息集合
     */
    public List<Task> getAllTask() {
        // TODO Auto-generated method stub
        return taskDao.getAllTask();
    }

    /**
     * 多条件查询任务信息
     *
     * @param builder   创建人
     * @param actor     执行人
     * @param taskTitle 任务主题
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 任务信息集合
     */
    @Override
    public List<Task> getAllTask(String builder, String actor, String taskTitle, String startTime, String endTime) {
        return taskDao.getAllTask(builder, actor, taskTitle, startTime, endTime);
    }

    @Override
    public Task getTaskById(int id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public int deleteMoreTask(Integer[] TaksList) {
        return taskDao.deleteMoreTask(TaksList);
    }

}
