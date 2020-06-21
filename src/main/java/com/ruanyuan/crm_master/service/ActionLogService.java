package com.ruanyuan.crm_master.service;

import java.util.List;

import com.ruanyuan.crm_master.dao.ActionLogDao;
import com.ruanyuan.crm_master.pojo.ActionLog;
import org.apache.ibatis.annotations.Param;

/**
 * 操作日志业务类
 *
 * @author zbp
 */
public interface ActionLogService {
    /**
     * 添加操作日志信息
     *
     * @param ActionLog 操作日志实体类对象
     * @return 影响的行数
     */
    public int addActionLog(ActionLog ActionLog);

    /**
     * 删除操作日志信息
     *
     * @param id 操作日志id
     * @return 影响的行数
     */
    public int deleteActionLog(int id);

    /**
     * 修改操作日志信息
     *
     * @param ActionLog 操作日志实体类对象
     * @return 影响的行数
     */
    public int updateActionLog(ActionLog ActionLog);

    /**
     * 获取所有操作日志信息
     *
     * @return 操作日志信息集合
     */
    public List<ActionLog> getAllActionLog();

    /**
     * 操作日志多条件查询
     *
     * @param empName 员工姓名
     * @param actTime 操作时间开始
     * @param endTime 操作时间结束
     * @return 操作日志集合
     */
    public List<ActionLog> getActionLog(String empName, String actTime, String endTime);

    /**
     * 批量删除操作日志信息
     *
     * @param AcitonLogList 操作日志id集合
     * @return 影响的行数
     */
    public int deleteMoreActionLog(Integer[] AcitonLogList);
}
