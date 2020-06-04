package com.ruanyuan.crm_master.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门实体类
 *
 * @author zbp
 */
@Data
public class Department implements Serializable {
    // 部门id
    private int deptId;
    // 部门名称
    private String deptName;
    // 创建时间
    private String deptTime;
    // 备注
    private String deptRemark;

}
