package com.ruanyuan.crm_master.controller;

import com.ruanyuan.crm_master.dao.RoleDao;
import com.ruanyuan.crm_master.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleControllerTest {
    @Autowired
    private RoleDao roleDao;

    @Test
    public void test() {
        List<Role> allRole = roleDao.getAllRole();
        for (Role role :
                allRole) {
            System.out.println(role);

        }
    }

}