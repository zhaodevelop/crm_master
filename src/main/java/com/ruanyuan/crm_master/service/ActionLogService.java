package com.ruanyuan.crm_master.service;

import java.util.List;

import com.ruanyuan.crm_master.dao.ActionLogDao;
import com.ruanyuan.crm_master.pojo.ActionLog;

/**
 * 操作日志业务类
 * 
 * @author zbp
 *
 */
public interface ActionLogService {
	/**
	 * 添加操作日志信息
	 * 
	 * @param ActionLog
	 * @return 影响的行数
	 */
	public int addActionLog(ActionLog ActionLog);

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
	 * @param ActionLog
	 * @return 影响的行数
	 */
	public int updateActionLog(ActionLog ActionLog);

	/**
	 * 获取所有操作日志信息
	 * 
	 * @return 操作日志信息集合
	 */
	public List<ActionLogDao> getAllActionLog();
}
