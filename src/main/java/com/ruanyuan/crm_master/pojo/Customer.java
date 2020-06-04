package com.ruanyuan.crm_master.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 客户实体类
 *
 * @author zbp
 */
@Data
public class Customer implements Serializable {
    // 客户id
    private int custId;
    // 客户姓名
    private String custName;
    // 客户信息来源
    private String custSource;
    // 性别
    private String custSex;
    // 联系方式
    private String custTel;
    // 邮箱
    private String custEmail;
    // 地址
    private String custAddress;
    // 客户创建时间
    private String custCreatetime;
    // 备注
    private String custRemark;
    // 员工表外键
    private Employee employee;
}
