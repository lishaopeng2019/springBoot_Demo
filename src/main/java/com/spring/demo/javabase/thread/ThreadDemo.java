package com.spring.demo.javabase.thread;

import io.netty.util.internal.ThreadExecutorMap;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/19 18:00
 * @Version: 1.0
 */
public class ThreadDemo implements Runnable{

	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadDemo());
		thread.setDaemon(true); // 设置子线程为守护线程
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is end");
	}

	@Override
	public void run() {
		System.out.println("enter " + Thread.currentThread().getName());
		while (true) {
			System.out.println(Thread.currentThread().getName() + " is alive");
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("finally block");
			}
		}
	}
}
