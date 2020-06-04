package com.ruanyuan.crm_master.service.impl;

import java.util.List;


import com.ruanyuan.crm_master.dao.RoleDao;
import com.ruanyuan.crm_master.pojo.Department;
import com.ruanyuan.crm_master.pojo.Role;
import com.ruanyuan.crm_master.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色业务接口实现类
 *
 * @author zbp
 */
@Service
public class RoleServiceImpl implements RoleService {
    // 注入角色方法接口
    @Autowired
    private RoleDao roleDao;

    /**
     * 添加角色
     */
    @Override
    public int addRole(Role role) {
        // TODO Auto-generated method stub
        return roleDao.addRole(role);
    }

    /**
     * 删除角色
     */
    @Override
    public int deleteRole(int id) {
        // TODO Auto-generated method stub
        return roleDao.deleteRole(id);
    }

    /**
     * 修改角色
     */
    @Override
    public int updateRole(Role role) {
        // TODO Auto-generated method stub
        return roleDao.updateRole(role);
    }

    /**
     * 获取所有角色
     *
     * @return 角色信息集合
     */
    @Override
    public List<Role> getAllRole() {
        // TODO Auto-generated method stub
        return roleDao.getAllRole();
    }

    /**
     * 根据角色名称多条件查询
     *
     * @param roleName 角色名称
     * @return 角色信息集合
     */
    @Override
    public List<Role> getAllRole(String roleName) {
        return roleDao.getAllRole(roleName);
    }

    /**
     * 根据id查询角色信息
     *
     * @param id 角色id
     * @return 角色实体类对象
     */
    public Role getRoleById(Integer id) {
        return roleDao.getRoleById(id);
    }

    /**
     * 批量删除角色
     *
     * @param roleList 角色id集合
     */
    public int deleteMoreRole(Integer[] roleList) {
        return roleDao.deleteMoreRole(roleList);
    }

}
