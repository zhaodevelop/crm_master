package com.ruanyuan.crm_master.service.impl;

import java.util.List;

import com.ruanyuan.crm_master.dao.DepartmentDao;
import com.ruanyuan.crm_master.pojo.Department;
import com.ruanyuan.crm_master.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 部门业务实现类
 *
 * @author zbp
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    // 注入部门方法接口
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 添加部门
     */
    @Override
    public int addDept(Department dept) {
        // TODO Auto-generated method stub
        return departmentDao.addDept(dept);
    }

    /**
     * 删除部门
     */
    @Override
    public int deleteDept(int id) {
        // TODO Auto-generated method stub
        return departmentDao.deleteDept(id);
    }

    /**
     * 修改部门
     */
    @Override
    public int updateDept(Department dept) {
        // TODO Auto-generated method stub
        return departmentDao.updateDept(dept);
    }

    /**
     * 获取所有部门
     */
    @Override
    public List<Department> getAllDept() {
        // TODO Auto-generated method stub
        return departmentDao.getAllDept();
    }

    /**
     * 多条件获取部门
     */
    @Override
    public List<Department> getAllDept(String deptName) {
        // TODO Auto-generated method stub
        return departmentDao.getAllDept(deptName);
    }

    /**
     * 根据id查询部门信息
     *
     * @param id 部门id
     * @return 部门实体类对象
     */
    @Override
    public Department getDeptById(Integer id) {
        return departmentDao.getDeptById(id);
    }

    /**
     * 批量删除部门信息
     *
     * @param deptList 部门id集合
     * @return 影响的行数
     */
    @Override
    public int deleteMoreDept(Integer[] deptList) {
        return departmentDao.deleteMoreDept(deptList);
    }

}
