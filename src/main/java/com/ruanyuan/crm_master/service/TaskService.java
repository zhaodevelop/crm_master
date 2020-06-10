package com.ruanyuan.crm_master.service;

import java.util.List;

import com.ruanyuan.crm_master.pojo.Task;
import org.apache.ibatis.annotations.Param;

/**
 * 任务业务类
 *
 * @author zbp
 */
public interface TaskService {
    /**
     * 添加任务信息
     *
     * @param task
     * @return 影响的行数
     */
    public int addTask(Task task);

    /**
     * 删除任务信息
     *
     * @param id
     * @return 影响的行数
     */
    public int deleteTask(int id);

    /**
     * 修改任务信息
     *
     * @param task
     * @return 影响的行数
     */
    public int updateTask(Task task);

    /**
     * 获取所有任务信息
     *
     * @return 任务信息集合
     */
    public List<Task> getAllTask();

    /**
     * 多条件查询任务信息
     *
     * @param taskTitle
     * @param taskState
     * @param empName
     * @param startTime
     * @param endTime
     * @return 任务集合
     */
    public List<Task> getAllTask(String taskTitle, String taskState, String empName, String startTime, String endTime);

    /**
     * 根据id查询任务信息
     *
     * @param id 任务id
     * @return 任务实体类对象
     */
    public Task getTaskById(int id);

    /**
     * 批量删除任务信息
     *
     * @param TaksList 任务id集合
     * @return 影响的行数
     */
    public int deleteMoreTask(Integer[] TaksList);
}
