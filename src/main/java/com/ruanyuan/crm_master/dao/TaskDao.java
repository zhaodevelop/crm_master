package com.ruanyuan.crm_master.dao;

import com.ruanyuan.crm_master.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务方法接口类
 *
 * @author zbp
 */
public interface TaskDao {
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
     * @param taskTitle 任务主题
     * @param taskState 任务状态
     * @param empName   创建人
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 任务信息集合
     */
    public List<Task> getAllTask(@Param("taskTitle") String taskTitle, @Param("taskState") String taskState, @Param("taskBuilder") String taskBuilder, @Param("startTime") String startTime, @Param("endTime") String endTime);

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
