package com.ruanyuan.crm_master.dao;

import com.ruanyuan.crm_master.pojo.Department;
import com.ruanyuan.crm_master.pojo.Role;

import java.util.List;


/**
 * 角色方法接口类
 *
 * @author zbp
 */
public interface RoleDao {
    /**
     * 添加角色
     *
     * @param role
     * @return 影响的行数
     */
    public int addRole(Role role);

    /**
     * 删除角色
     *
     * @param id
     * @return 影响的行数
     */
    public int deleteRole(int id);

    /**
     * 修改角色
     *
     * @param role
     * @return 影响的行数
     */
    public int updateRole(Role role);

    /**
     * 获取所有角色
     *
     * @return 角色信息集合
     */
    public List<Role> getAllRole();

    /**
     * 根据角色名称多条件查询
     *
     * @param roleName 部门名称
     * @return 部门信息集合
     */
    public List<Role> getAllRole(String roleName);


    /**
     * 根据id查询角色信息
     *
     * @param id 角色id
     * @return 角色实体类对象
     */
    public Role getRoleById(Integer id);

    /**
     * 批量删除角色
     *
     * @param roleList 角色id集合
     */
    public int deleteMoreRole(Integer[] roleList);

}
