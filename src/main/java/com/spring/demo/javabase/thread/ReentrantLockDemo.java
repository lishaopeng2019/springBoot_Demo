package com.spring.demo.javabase.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: ReentrantLock
 * @Author: Super
 * @CreateDate: 2020/7/17 15:20
 * @Version: 1.0
 */
public class ReentrantLockDemo {
	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + ">> enter");
					lock1.lock();
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + ">> get lock 1");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					lock1.unlock();
				}
			}
		}).start();

		try {
			Thread.sleep(300); // 睡会,保证进到子线程
			System.out.println("哈哈哈");
			lock1.lock();
			System.out.println(Thread.currentThread().getName() + ">> get lock 1");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock1.unlock();
		}
	}


}
