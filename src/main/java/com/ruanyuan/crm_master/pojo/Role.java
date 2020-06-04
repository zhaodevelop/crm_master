package com.ruanyuan.crm_master.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色实体类
 * 
 * @author zbp
 *
 */
@Data
public class Role  implements Serializable {
	// 角色Id
	private int roleId;
	// 角色名称
	private String roleName;
	// 备注
	private String roleRemark;
}
