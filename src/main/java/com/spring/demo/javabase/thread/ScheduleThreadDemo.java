package com.spring.demo.javabase.thread;

import com.spring.demo.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Description: 定时线程
 * @Author: Super
 * @CreateDate: 2020/7/16 16:34
 * @Version: 1.0
 */
public class ScheduleThreadDemo {

	public static void main(String[] args) {
		circleScheduleTask();
	}

	// 定时任务：定时线程启动后，5s后执行任务
	public static void singleScheduleTask() {
		// 获取单定时线程池
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		// 创建一个定时线程
		ScheduledFuture<String> schedule = scheduledExecutorService.schedule(new Callable<String>() {
			@Override
			public String call() {
				System.out.println("定时任务已启动.");
				return "执行任务的线程: " + Thread.currentThread().getName();
			}
		}, 5000, TimeUnit.MILLISECONDS); // TimeUnit.MILLISECONDS 毫秒
		try {
			System.out.println(schedule.get());
		} catch (Exception e) {
			System.out.println("执行定时任务异常" + e.getMessage());
		}
		// 关闭线程池
		scheduledExecutorService.shutdown();
	}

	public static void circleScheduleTask() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleWithFixedDelay(new Runnable() {
			private int count = 0;
			private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
			@Override
			public void run() {
				String time = simpleDateFormat.format(new Date());
				System.out.println(time + " >>第"+ (++count) + "次执行定时任务.");
			}
		}, 0, 2000, TimeUnit.MILLISECONDS);
	}


}
