package com.spring.demo.javabase.thread;

/**
 * @Description: 死锁
 * @Author: Super
 * @CreateDate: 2020/7/17 13:24
 * @Version: 1.0
 */
public class DeadLock {
	private static final Object LOCK_A = "lock_a";
	private static final Object LOCK_B = "lock_b";

	public static void main(String[] args) {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				synchronized (LOCK_A) {
//					System.out.println(Thread.currentThread().getName() +">> get lock a");
//					synchronized (LOCK_B) {
//						System.out.println(Thread.currentThread().getName() + ">> get lock b");
//					}
//				}
//			}
//		}).start();
//
//		synchronized (LOCK_A) {
//			System.out.println(Thread.currentThread().getName() + ">> get lock a");
//			try {
//				Thread.sleep(3000); // 睡会，保证走到子线程
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			synchronized (LOCK_B) {
//				System.out.println(Thread.currentThread().getName() + ">> get lock b");
//			}
//		}
		test();
	}

	public static void test() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (LOCK_B) {
					System.out.println(Thread.currentThread().getName() +">> get lock b"); // 2
				}
				synchronized (LOCK_A) {
					System.out.println(Thread.currentThread().getName() + ">> get lock a"); // 3
				}
			}
		}).start();

		synchronized (LOCK_A) {
			System.out.println(Thread.currentThread().getName() + ">> get lock a"); // 1
			try {
				Thread.sleep(3000); // 睡会，保证走到子线程
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (LOCK_B) {
			System.out.println(Thread.currentThread().getName() + ">> get lock b"); // 4
		}
	}
}
