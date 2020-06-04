package com.ruanyuan.crm_master.dao;

import com.ruanyuan.crm_master.pojo.ActionLog;

import java.util.List;

/**
 * 操作日志接口类
 * 
 * @author zbp
 *
 */
public interface ActionLogDao {
	/**
	 * 添加操作日志信息
	 * 
	 * @param actionLog
	 * @return 影响的行数
	 */
	public int addActionLog(ActionLog actionLog);

	/**
	 * 删除操作日志信息
	 * 
	 * @param id
	 * @return 影响的行数
	 */
	public int deleteActionLog(int id);

	/**
	 * 修改操作日志信息
	 * 
	 * @param actionLog
	 * @return 影响的行数
	 */
	public int updateActionLog(ActionLog actionLog);

	/**
	 * 获取所有操作日志信息
	 * 
	 * @return 操作日志信息集合
	 */
	public List<ActionLogDao> getAllActionLog();
}
