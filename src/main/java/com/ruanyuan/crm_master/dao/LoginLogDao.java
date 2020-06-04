package com.ruanyuan.crm_master.dao;

import java.util.List;

/**
 * 登录日志方法接口类
 * 
 * @author zbp
 *
 */
public interface LoginLogDao {
	/**
	 * 添加登录日志信息
	 * 
	 * @param LoginLog
	 * @return 影响的行数
	 */
	public int addLoginLog(LoginLogDao LoginLog);

	/**
	 * 删除登录日志信息
	 * 
	 * @param id
	 * @return 影响的行数
	 */
	public int deleteLoginLog(int id);

	/**
	 * 修改登录日志信息
	 * 
	 * @param LoginLog
	 * @return 影响的行数
	 */
	public int updateLoginLog(LoginLogDao LoginLog);

	/**
	 * 获取所有登录日志信息
	 * 
	 * @return 登录日志信息集合
	 */
	public List<LoginLogDao> getAllLoginLog();
}
