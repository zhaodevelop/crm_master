package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.pojo.Role;
import com.ruanyuan.crm_master.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    //注入角色业务层
    @Autowired
    private RoleService roleService;

    //查询所有角色
    @RequestMapping("/getAllRoles")
    public List<Role> getAllRoles() {
        //执行查询所有角色方法
        List<Role> allRole = roleService.getAllRole();
        System.out.println(allRole);
        return allRole;
    }

    //分页展示所有角色
    @GetMapping("/getAllRoles/{page}/{size}")
    public PageInfo<Role> getAllRole(@PathVariable("page") Integer pageNo, @PathVariable("size") Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有角色方法
        List<Role> allRole = roleService.getAllRole();
        System.out.println(allRole);
        PageInfo<Role> rolePageInfo = new PageInfo<Role>(allRole);
        return rolePageInfo;
    }

    @PostMapping("/getAllRoles/{page}/{size}")
    public PageInfo<Role> getAllRole(@PathVariable("page") Integer pageNo, @PathVariable("size") Integer pageSize, String roleName) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有角色方法
        List<Role> allRole = roleService.getAllRole(roleName);
        PageInfo<Role> rolePageInfo = new PageInfo<Role>(allRole);
        return rolePageInfo;
    }

    //添加角色方法
    @PostMapping("/addRole")
    public int addRole(@RequestBody Role role) {
        int i = roleService.addRole(role);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //修改角色方法
    @PutMapping("/updateRole")
    public int updateRole(Role role) {
        int i = roleService.updateRole(role);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id删除角色
    @RequestMapping("/delRoleById/{id}")
    public int deleteRoleById(@PathVariable("id") Integer id) {
        int i = roleService.deleteRole(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id查询角色信息
    @GetMapping("/getRoleById/{id}")
    public Role getRoleById(@PathVariable("id") Integer id) {
        //执行根据id查询角色信息方法
        Role role = roleService.getRoleById(id);
        return role;
    }

    //批量删除角色信息
    @DeleteMapping("/delRoles")
    public int delRoles(Integer[] ids) {
        int i = roleService.deleteMoreRole(ids);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
