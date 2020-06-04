package com.ruanyuan.crm_master.service;

import com.ruanyuan.crm_master.dao.InterviewDao;
import com.ruanyuan.crm_master.pojo.Interview;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 访谈业务类
 *
 * @author zbp
 */
public interface InterviewService {
    /**
     * 添加访谈信息
     *
     * @param interview
     * @return 影响的行数
     */
    public int addInterview(Interview interview);

    /**
     * 删除访谈信息
     *
     * @param id
     * @return 影响的行数
     */
    public int deleteInterview(int id);

    /**
     * 修改访谈信息
     *
     * @param interview
     * @return 影响的行数
     */
    public int updateInterview(Interview interview);

    /**
     * 获取所有访谈信息
     *
     * @return 访谈信息集合
     */
    public List<Interview> getAllInterview();

    /**
     * 多条件查询访谈信息
     *
     * @param custName      客户姓名
     * @param empName       负责人
     * @param interDateTime 访谈时间
     * @param endTime       结束时间
     * @return 访谈信息集合
     */
    public List<Interview> getAllInterview(String custName, String empName, String interDateTime, String endTime);

    /**
     * 根据id查询访谈信息
     *
     * @param id 访谈id
     * @return 访谈实体类对象
     */
    public Interview getInterviewById(int id);

    /**
     * 批量删除访谈信息
     *
     * @param InterviewList 访谈id集合
     * @return 影响的行数
     */
    public int deleteMoreInterview(Integer[] InterviewList);
}
