package JDKWebFrame.jobs.tasks.timetaskjobclass;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask4 {
	
	@Scheduled(cron="*/1 * * * * ?")
	public void doTask(){
		System.out.println("这是一个直接在类里注解的方式的TimeTask4测试任务");
	}
}
