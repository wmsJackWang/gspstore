package JDKWebFrame.jobs.quartzs.dynaticquartz.page;

import com.core.base.BasePage;

public class QuartzPage extends BasePage  implements java.io.Serializable{

	
	/*
	 * 定时任务序列
	 */
	private String quartzNo;
	
	
	/*
	 * 定时任务功能描述(中文名)
	 */
	private String bussinessName;
	
	/*
	 * 定时任务类路径名
	 */
	private String taskClassName;
	/*
	 * 定时任务类名称
	 */
	private String jobName;
	
	/*
	 * 定时任务类组名
	 */
	private String jobGroupName;
	
	/*
	 * 定时任务触发器名称
	 */
	private String triggerName;
	
	/*
	 * 定时任务触发器组名称
	 */
	private String triggerGroupName;
	
	/*
	 * 时间
	 */
	private String cronTime;
	
	/*
	 * 任务是否开机自动重启(取值:Y/N)
	 */
	private String autoStartup;
	
	/*
	 * 任务状态: running : 运行中 ；stopped : 已停止。
	 */
	private String status;
	
	/*
	 * 创建人id
	 */
	private String createdUserId;
	
	/*
	 * 最后修改人ID
	 */
	private String lastModifyUserId;

	public String getQuartzNo() {
		return quartzNo;
	}

	public void setQuartzNo(String quartzNo) {
		this.quartzNo = quartzNo;
	}

	public String getBussinessName() {
		return bussinessName;
	}
	
	public String getTaskClassName() {
		return taskClassName;
	}

	public void setTaskClassName(String taskClassName) {
		this.taskClassName = taskClassName;
	}

	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroupName() {
		return triggerGroupName;
	}

	public void setTriggerGroupName(String triggerGroupName) {
		this.triggerGroupName = triggerGroupName;
	}

	public String getCronTime() {
		return cronTime;
	}

	public void setCronTime(String cronTime) {
		this.cronTime = cronTime;
	}

	public String getAutoStartup() {
		return autoStartup;
	}

	public void setAutoStartup(String autoStartup) {
		this.autoStartup = autoStartup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getLastModifyUserId() {
		return lastModifyUserId;
	}

	public void setLastModifyUserId(String lastModifyUserId) {
		this.lastModifyUserId = lastModifyUserId;
	}


	
	
}
