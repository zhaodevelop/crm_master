package com.ruanyuan.crm_master.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录日志实体类
 *
 * @author zbp
 */
@Data
public class LoginLog implements Serializable {
    // 登录日志id
    private int logId;
    // 用户ip
    private String logIp;
    // 登录时间
    private String logTime;
    // 登录地址
    private String logaddr;
    // 员工外键
    private Employee employee;
}
