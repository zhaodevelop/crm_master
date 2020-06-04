package com.ruanyuan.crm_master.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 访谈实体类
 * 
 * @author zbp
 *
 */
@Data
public class Interview implements Serializable {
	// 访谈ID
	private int interId;
	// 访谈内容
	private String interInfo;
	// 访谈记录
	private String interRecode;
	// 访谈时间
	private String interDatetime;
	// 访谈备注
	private String interRemark;
	// 客户外键
	private Customer customer;
	// 员工外键
	private Employee employee;
}
