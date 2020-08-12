package com.spring.demo.javabase.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 线程的基本操作
 * @Author: Super
 * @CreateDate: 2020/7/18 15:12
 * @Version: 1.0
 */
public class ThreadOperation {
	static Object lock = new Object();

	public static void main(String[] args) {

		waitTest();
	}

	// suspend不会释放锁
	public static void suspendTest() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("已进入线程 " + Thread.currentThread().getName());
					Thread.currentThread().suspend();
					System.out.println(Thread.currentThread().getName() + " is end");
				}
			}
		});
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(1); // Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.resume(); // 释放挂起的线程
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " is end");
		}

	}

	// wait会释放锁
	public static void waitTest() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("已进入线程 " + Thread.currentThread().getName());
					try {
						lock.wait(1000); // 此线程释放锁加入等待队列, 1s后又争夺资源
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " is end");
				}
			}
		});
		thread.start();
		try {
			Thread.sleep(300); // 睡会,保证进入子线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("哈哈哈");
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " is end");
			System.out.println(thread.getState());
		}
	}


	// sleep不会让出锁
	public static void sleepTest() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("已进入线程 " + Thread.currentThread().getName()); // 1
					try {
						Thread.sleep(1000); // 睡会,切换到主线程,看看主线程能不能拿到锁
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " is end"); // 3
			}
		});
		thread.start();
		try {
			Thread.sleep(300); // 睡会,保证进入子线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("哈哈哈"); // 2
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " is end"); // 4
		}
	}

	// stop不安全已被弃用,stop会释放锁,线程立马终止,finally中的还是会执行
	public static void stopTest() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("已进入线程 " + Thread.currentThread().getName());
				System.out.println("status3 is " + Thread.currentThread().getState()); // RUNNABLE
				try {
					Thread.sleep(3000); // 等待2s保证线程running中被执行的stop
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("能不能走到我");
				}
				System.out.println("在我之前线程已done");
			}
		});
		System.out.println("status1 is " + thread.getState()); // NEW
		thread.start();
		System.out.println("status2 is " + thread.getState()); // RUNNABLE
		try {
			Thread.sleep(1000); // 等待1s保证执行到子线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.stop();
		try {
			Thread.sleep(1000); // 等待1s保证子线程被完全终止
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("status4 is " + thread.getState()); // TERMINATED
		System.out.println("main end");
	}

	/**
	 * interrupt(),interrupted(),isInterrupted()
	 */
	public static void interruptedTest() {
		Thread thread= new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread.interrupted() " + Thread.interrupted()); // true
				System.out.println("isInterrupted second " + Thread.currentThread().isInterrupted()); // true
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread.interrupted() " + Thread.interrupted()); // true
				System.out.println(Thread.currentThread().getName() + "运行结束");
			}
		});
		thread.start();
		thread.interrupt();
		System.out.println("isInterrupted first " + thread.isInterrupted()); // true
		System.out.println(Thread.currentThread().getName() + "运行结束");
	}

	// join() 在线程1中线程2调用join,线程1会等待线程2执行完毕后才会继续往下走
	public static void joinTest() {
		Thread thread_a = new Thread(new ThreadDemo(), "Thread_a");
		thread_a.start();
		try {
			thread_a.join(); // Thread_a 运行完毕,主线程才会往下走
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "正在运行");
	}

	static class ThreadDemo implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " 正在执行");
		}
	}
}
