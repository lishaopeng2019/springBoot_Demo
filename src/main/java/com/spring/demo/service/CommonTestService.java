package com.spring.demo.service;

import java.util.List;

public interface CommonTestService {

	/**
	 * 异步方法测试
	 */
	void asyncTest(List<Integer> ids);

	/**
	 * 同步测试，对比异步结果
	 */
	void syncTest(List<Integer> ids);
}
