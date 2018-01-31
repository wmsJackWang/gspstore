package JDKWebFrame.jobs.quartzs.quartzsjobclass;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/*
 * 测试spring Quartz的不使用 org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean
 * 工作类继承org.springframework.scheduling.quartz.QuartzJobBean
 */
public class QuartzJob1  extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		System.out.println("配置方式测试spring quartz 使用  QuartzJobBean的方式");
	}

}
