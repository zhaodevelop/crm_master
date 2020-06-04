package com.ruanyuan.crm_master.service;

import com.ruanyuan.crm_master.dao.LoginLogDao;
import com.ruanyuan.crm_master.pojo.LoginLog;

import java.util.List;


/**
 * 登录日志业务类
 * 
 * @author zbp
 *
 */
public interface LoginLogService {
	/**
	 * 添加登录日志信息
	 * 
	 * @param LoginLog
	 * @return 影响的行数
	 */
	public int addLoginLog(LoginLog LoginLog);

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
	public int updateLoginLog(LoginLog LoginLog);

	/**
	 * 获取所有登录日志信息
	 * 
	 * @return 登录日志信息集合
	 */
	public List<LoginLogDao> getAllLoginLog();
}
