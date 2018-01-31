package com.jeecg.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob2 {

	/*
	 * 每个星期三都执行定时任务
	 * 
	 */
	@Scheduled(cron="*/5 * * * * *")
	public void excute(){
		
		System.out.println("MyJob2类定时测试");
	}
}
