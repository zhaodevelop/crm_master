package com.ruanyuan.crm_master.service.impl;

import java.util.List;

import com.ruanyuan.crm_master.dao.ActionLogDao;
import com.ruanyuan.crm_master.pojo.ActionLog;
import com.ruanyuan.crm_master.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 操作日志业务接口实现类
 *
 * @author zbp
 */
@Service
public class ActionLogServiceImpl implements ActionLogService {
    // 注册操作日志方法接口
    @Autowired
    private ActionLogDao actionLogDao;

    /**
     * 添加操作日志信息
     */
    @Override
    public int addActionLog(ActionLog actionLog) {
        // TODO Auto-generated method stub
        return actionLogDao.addActionLog(actionLog);
    }

    /**
     * 删除操作日志信息
     */
    @Override
    public int deleteActionLog(int id) {
        // TODO Auto-generated method stub
        return actionLogDao.deleteActionLog(id);
    }


    @Override
    public int updateActionLog(ActionLog actionLog) {
        // TODO Auto-generated method stub
        return actionLogDao.updateActionLog(actionLog);
    }

    /**
     * 查询所有操作日志信息
     *
     * @return 操作日志信息集合
     */
    @Override
    public List<ActionLogDao> getAllActionLog() {
        // TODO Auto-generated method stub
        return actionLogDao.getAllActionLog();
    }

}
