package com.ruanyuan.crm_master.dao;

import com.ruanyuan.crm_master.pojo.Task;

import java.util.List;

/**
 * 任务方法接口类
 * 
 * @author zbp
 *
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
	public int updateTask(TaskDao task);

	/**
	 * 获取所有任务信息
	 * 
	 * @return 任务信息集合
	 */
	public List<Task> getAllTask();
}
