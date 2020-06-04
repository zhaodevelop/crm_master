package com.ruanyuan.crm_master.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 操作日志实体类
 * 
 * @author zbp
 *
 */
@Data
public class ActionLog implements Serializable {
	// 操作日志id
	private int actLogId;
	// 操作时间
	private String actTime;
	// 操作类型
	private String actType;
	// 操作内容
	private String operateContent;
	// 操作人
	private Employee employee;
}
