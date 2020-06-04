package com.ruanyuan.crm_master.service.impl;

import java.util.List;

import com.ruanyuan.crm_master.dao.InterviewDao;
import com.ruanyuan.crm_master.pojo.Interview;
import com.ruanyuan.crm_master.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 访谈业务接口实现类
 *
 * @author zbp
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    // 注册访谈方法接口
    @Autowired
    private InterviewDao interviewDao;

    /**
     * 添加访谈信息
     */
    @Override
    public int addInterview(Interview interview) {
        // TODO Auto-generated method stub
        return interviewDao.addInterview(interview);
    }

    /**
     * 删除访谈信息
     */
    @Override
    public int deleteInterview(int id) {
        // TODO Auto-generated method stub
        return interviewDao.deleteInterview(id);
    }

    /**
     * 修改访谈信息
     */
    @Override
    public int updateInterview(Interview interview) {
        // TODO Auto-generated method stub
        return interviewDao.updateInterview(interview);
    }

    /**
     * 查询所有访谈信息
     *
     * @return 访谈信息集合
     */
    @Override
    public List<Interview> getAllInterview() {
        // TODO Auto-generated method stub
        return interviewDao.getAllInterview();
    }

    /**
     * 多条件查询访谈信息
     *
     * @param custName      客户姓名
     * @param empName       负责人
     * @param interDateTime 访谈时间
     * @param endTime       结束时间
     * @return 访谈信息集合
     */
    public List<Interview> getAllInterview(String custName, String empName, String interDateTime, String endTime) {
        return interviewDao.getAllInterview(custName, empName, interDateTime, endTime);
    }

    /**
     * 根据id查询访谈信息
     *
     * @param id 访谈id
     * @return 访谈信息实体类对象
     */
    @Override
    public Interview getInterviewById(int id) {
        return interviewDao.getInterviewById(id);
    }

    /**
     * 批量删除访谈信息
     *
     * @param InterviewList 访谈id集合
     * @return 影响的行数
     */
    @Override
    public int deleteMoreInterview(Integer[] InterviewList) {
        return interviewDao.deleteMoreInterview(InterviewList);
    }


}
