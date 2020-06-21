package com.ruanyuan.crm_master.dao;

import com.ruanyuan.crm_master.pojo.LoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 登录日志方法接口类
 *
 * @author zbp
 */
public interface LoginLogDao {
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
    public List<LoginLog> getAllLoginLog();

    /**
     * 多条件查询登录日志信息
     *
     * @param logTime 登录日志生成时间
     * @param endTime 登录日志截止时间
     * @return 登录日志信息集合
     */
    public List<LoginLog> getAllLoginLog(@Param("logTime") String logTime, @Param("endTime") String endTime);

    /**
     * 根据id查询登录日志信息
     *
     * @param id 登录日志id
     * @return 登录日志实体类对象
     */
    public LoginLog getLoginLogById(int id);

    /**
     * 批量删除登录日志信息
     *
     * @param LoginLogList 登录日志id集合
     * @return 影响的行数
     */
    public int deleteMoreLoginLog(Integer[] LoginLogList);

}
