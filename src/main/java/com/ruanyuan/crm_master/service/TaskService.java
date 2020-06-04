package com.ruanyuan.crm_master.service;

import java.util.List;

import com.ruanyuan.crm_master.pojo.Task;

/**
 * 任务业务类
 * 
 * @author zbp
 *
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
}
