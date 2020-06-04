package com.ruanyuan.crm_master.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 任务实体类
 * 
 * @author zbp
 *
 */
@Data
public class Task implements Serializable {
	// 任务id
	private int taskId;
	// 任务主题
	private String taskTitle;
	// 任务内容
	private String taskInfo;
	// 任务执行状态
	private String taskState;
	// 任务的创建时间
	private String startTime;
	// 任务的截止时间
	private String endTime;
	// 备注
	private String taskRemark;
	// 任务创建人
	private Employee taskBuilder;
	// 任务执行人
	private Employee taskActor;
}
