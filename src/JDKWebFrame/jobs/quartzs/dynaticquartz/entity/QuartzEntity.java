package JDKWebFrame.jobs.quartzs.dynaticquartz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity        
@Table(name = "jeecg_quartzinfo" , schema = "")
public class QuartzEntity  implements Serializable{

	
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "QUARTZNO" , nullable = false , length = 50)
	private String quartzNo;
	
	
	@Column(name = "BUSSINESSNAME" , nullable = false , length = 40)
	private String bussinessName ;
	
	@Column(name = "TASKCLASSNAME" , nullable = false , length = 100)
	private String taskClassName ;
	
	
	@Column(name = "JOBNAME" , nullable = false , length = 40)
	private String jobName;
	

	@Column(name = "JOBGROUPNAME" , length = 40)
	private String jobGroupName;
	

	@Column(name = "TRIGGERNAME" , length = 40)
	private String triggerName;
	
	
	@Column(name = "TRIGGERGROUPNAME" , length = 40)
	private String triggerGroupName;
		
	
	@Column(name = "CRONTIME" , nullable = false , length = 30)
	private String cronTime;
	
	@Column(name = "AUTOSTARTUP" ,nullable = false , length = 5)//自动重启的两个值：Y/N
	private String autoStartup;
	
	@Column(name = "STATUS" , length = 10)//任务状体 running : 运行中 ;Stopped : 已停止
	private String status;
	
	@Column(name = "CREATEDUSERID" , length = 20)
	private String createdUserId;
	
	@Column(name = "LASTMODIFYUSERID" , length = 20)
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

	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}

	public String getTaskClassName() {
		return taskClassName;
	}

	public void setTaskClassName(String taskClassName) {
		this.taskClassName = taskClassName;
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
