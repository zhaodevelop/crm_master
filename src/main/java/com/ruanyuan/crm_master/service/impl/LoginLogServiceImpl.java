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
        return loginLogDao.addLoginLog((LoginLogDao) loginLog);
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
        return loginLogDao.updateLoginLog((LoginLogDao) loginLog);
    }

    /**
     * 查询所有登录日志信息
     *
     * @return 登录日志信息集合
     */
    @Override
    public List<LoginLogDao> getAllLoginLog() {
        // TODO Auto-generated method stub
        return loginLogDao.getAllLoginLog();
    }

}
