package com.ruanyuan.crm_master.dao;

import java.util.List;

import com.ruanyuan.crm_master.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门方法接口类
 *
 * @author zbp
 */
@Mapper//说明是操作数据库的mapper	
public interface DepartmentDao {
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
     * 根据部门名称多条件查询
     *
     * @param deptName 部门名称
     * @return 部门信息集合
     */
    public List<Department> getAllDept(String deptName);

    /**
     * 根据id查询部门信息
     *
     * @param id 部门id
     * @return 部门实体类对象
     */
    public Department getDeptById(Integer id);

    /**
     * 批量删除部门
     *
     * @param deptList 部门id集合
     */
    public int deleteMoreDept(Integer[] deptList);
}
