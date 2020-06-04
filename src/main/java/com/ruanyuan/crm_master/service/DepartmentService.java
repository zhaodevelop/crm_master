package com.ruanyuan.crm_master.service;

import com.ruanyuan.crm_master.pojo.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;


/**
 * 部门业务类
 *
 * @author zbp
 */
public interface DepartmentService {
    /**
     * 添加部门
     *
     * @param dept
     * @return 影响的行数
     */
    public int addDept(Department dept);

    /**
     * 删除部门
     *
     * @param id
     * @return 影响的行数
     */
    public int deleteDept(int id);

    /**
     * 修改部门
     *
     * @param dept
     * @return 影响的行数
     */
    public int updateDept(Department dept);

    /**
     * 获取所有部门
     *
     * @return 部门信息集合
     */
    public List<Department> getAllDept();

    /**
     * 多条件获取部门
     *
     * @return 部门信息集合
     */
    public List<Department> getAllDept(@Param("deptName") String deptName);

    /**
     * 根据id查询部门信息系
     *
     * @param id 部门id
     * @return 部门实体类对象
     */
    public Department getDeptById(Integer id);

    /**
     * 批量删除部门信息
     *
     * @param deptList 部门id集合
     */
    public int deleteMoreDept(Integer[] deptList);
}
