package com.ruanyuan.crm_master.dao;

import com.ruanyuan.crm_master.pojo.ActionLog;
import com.ruanyuan.crm_master.pojo.LoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作日志接口类
 *
 * @author zbp
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
    public List<ActionLog> getActionLog();

    /**
     * 操作日志多条件查询
     *
     * @param empName 员工姓名
     * @param actTime 操作时间开始
     * @param endTime 操作时间结束
     * @return 操作日志集合
     */
    public List<ActionLog> getActionLog(@Param("empName") String empName, @Param("actTime") String actTime, @Param("endTime") String endTime);

    /**
     * 批量删除操作日志信息
     *
     * @param AcitonLogList 登录日志id集合
     * @return 影响的行数
     */
    public int deleteMoreActionLog(Integer[] AcitonLogList);
}
