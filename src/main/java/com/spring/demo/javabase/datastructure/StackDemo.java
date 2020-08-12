package com.spring.demo.javabase.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 数据结构-栈 Stack
 * @Author: Super
 * @CreateDate: 2020/7/31 21:22
 * @Version: 1.0
 */
public class StackDemo {

	public static void main(String[] args) {
		stackTest();
	}

	public static void stackTest() {
		Integer[] arr = {1, 5, 10, 12};
		List<Integer> integers = Arrays.asList(arr);
		Stack<Integer> stack = new Stack<>();
		stack.addAll(integers); // extends Vector,也是一种容器
		System.out.println(stack.toString()); // [1, 5, 10, 12]
		stack.push(15); // 入栈,栈顶
		System.out.println(stack.toString()); // [1, 5, 10, 12, 15]
		System.out.println(stack.search(15)); // 1
		System.out.println(stack.peek()); // 15 查看栈顶元素
		System.out.println(stack.pop()); // 15 出栈,移除并返回栈顶元素
		System.out.println(stack.toString()); // [1, 5, 10, 12]
	}
}
