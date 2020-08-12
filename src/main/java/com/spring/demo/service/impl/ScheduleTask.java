package com.spring.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/10 9:51
 * @Version: 1.0
 */
@Slf4j
//@EnableScheduling // 开启定时任务
@Configuration // 此注解必须加,不加不会扫描到定时任务,也可使用@Component
public class ScheduleTask {
	private int count = 0;

	@Scheduled(initialDelay = 3000, fixedRateString = "5000")
	private void scheduleTask1() {
		log.info("method = scheduleTask1, schedule time is {}", System.currentTimeMillis());
	}

	@Scheduled(cron = "0 0/1 13 * * ?")
	private void scheduleTask() {
		log.info("execute 第{}次 scheduleTask", ++count);
	}

	@Scheduled(cron = "*/10 * * * * ?")
	private void scheduleTask3() {
		log.info("method = scheduleTask3, schedule time is {}", System.currentTimeMillis());
	}

	@Scheduled(cron = "0 50,55 * *  * ?")
	private void scheduleTask4() {
		log.info("method = scheduleTask4, schedule time is {}", System.currentTimeMillis());
	}
}
