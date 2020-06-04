package com.ruanyuan.crm_master.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 员工实体类
 *
 * @author zbp
 */
@Data
public class Employee implements Serializable {
    // 员工id
    private int empId;
    // 员工姓名
    private String empName;
    // 账号
    private String account;
    // 密码
    private String password;
    // 性别
    private String empSex;
    // 联系电话
    private String empTel;
    // 邮箱
    private String empEmail;
    // 联系地址
    private String empAddress;
    // 入职时间
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm" )
    private String empWorkTime;
    // 是否可用
    private String empOpen;
    // 状态
    private String empState;
    // 备注
    private String empRemark;
    // 部门外键
    private Department department;
    // 角色外键
    private Role role;
    //页数
    private Integer pageNo;
    //信息条数
    private Integer pageSize;
}
