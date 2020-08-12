package com.spring.demo.javabase;

import java.util.Scanner;

/**
 * @Description: 位运算
 * @Author: Super
 * @CreateDate: 2020/8/1 16:42
 * @Version: 1.0
 */
public class BitOperation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数,并按回车来判断奇偶性(输入-1代表退出程序)");
		while(sc.hasNext()) {
			int num = sc.nextInt();
			if (num == -1) {
				break;
			}
			oddOrEven(num);
		}
	}

	// 基本运算
	public static void baseOperation() {
		System.out.println("25的二进制位: " + Integer.toBinaryString(25));
		System.out.println("40的二进制位: " + Integer.toBinaryString(40));
		System.out.println("=======================================");
		System.out.println("25|40的二进制结果: " + Integer.toBinaryString(25|40));
		System.out.println("25|40的十进制结果: " + (25|40)); // 57
		System.out.println("=======================================");
		System.out.println("25&40的二进制结果: " + Integer.toBinaryString(25&40));
		System.out.println("25&40的十进制结果: " + (25&40)); // 8
		System.out.println("=======================================");
		System.out.println("~25的二进制结果: " + Integer.toBinaryString(~25));
		System.out.println("~25的十进制结果: " + (~25)); // -26
		System.out.println("=======================================");
		System.out.println("3^2的二进制结果: " + Integer.toBinaryString(3^2));
		System.out.println("3^2的十进制结果: " + (3^2)); // 1
		System.out.println("=======================================");
		System.out.println("2<<3的二进制结果: " + Integer.toBinaryString(2<<3));
		System.out.println("2<<3的十进制结果: " + (2<<3)); // 16
		System.out.println("=======================================");
		System.out.println("25>>2的二进制结果: " + Integer.toBinaryString(25>>2));
		System.out.println("25>>2的十进制结果: " + (25>>2)); // 6
		System.out.println("=======================================");
		System.out.println("-1>>>1的结果是: " + (-1>>>1)); // int的最大值
	}

	// 应用1:判断数的奇偶
	public static void oddOrEven(int num) {
		if ((num & 1) == 0) {
			System.out.println(num + " 是偶数");
		} else {
			System.out.println(num + " 是奇数");
		}

	}
}
