package com.ruanyuan.crm_master.service.impl;

import java.util.List;

import com.ruanyuan.crm_master.dao.LoginLogDao;
import com.ruanyuan.crm_master.pojo.LoginLog;
import com.ruanyuan.crm_master.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 登录日志业务接口实现类
 *
 * @author zbp
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    // 注册登录日志方法接口
    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * 添加登录日志信息
     */
    @Override
    public int addLoginLog(LoginLog loginLog) {
        // TODO Auto-generated method stub
        return loginLogDao.addLoginLog(loginLog);
    }

    /**
     * 删除登录日志信息
     */
    @Override
    public int deleteLoginLog(int id) {
        // TODO Auto-generated method stub
        return loginLogDao.deleteLoginLog(id);
    }

    /**
     * 修改登录日志信息
     */
    @Override
    public int updateLoginLog(LoginLog loginLog) {
        // TODO Auto-generated method stub
        return loginLogDao.updateLoginLog(loginLog);
    }

    /**
     * 查询所有登录日志信息
     *
     * @return 登录日志信息集合
     */
    @Override
    public List<LoginLog> getAllLoginLog() {
        // TODO Auto-generated method stub
        return loginLogDao.getAllLoginLog();
    }

    /**
     * 多条件查询登录日志信息
     *
     * @param logTime 登录日志生成时间
     * @param endTime 登录日志截止时间
     * @return 登录日志信息集合
     */
    @Override
    public List<LoginLog> getAllLoginLog(String logTime, String endTime) {
        return loginLogDao.getAllLoginLog(logTime, endTime);
    }

    /**
     * 根据id查询登录日志信息
     *
     * @param id 登录日志id
     * @return 登录日志实体类对象
     */
    @Override
    public LoginLog getLoginLogById(int id) {
        return loginLogDao.getLoginLogById(id);
    }

    /**
     * 批量删除登录日志信息
     *
     * @param LoginLogList 登录日志id集合
     * @return 影响的行数
     */
    @Override
    public int deleteMoreLoginLog(Integer[] LoginLogList) {
        return loginLogDao.deleteMoreLoginLog(LoginLogList);
    }

}
