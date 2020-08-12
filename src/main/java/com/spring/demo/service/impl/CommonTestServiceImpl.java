package com.spring.demo.service.impl;

import com.spring.demo.service.CommonTestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/9 16:18
 * @Version: 1.0
 */
@Component
@EnableAsync
public class CommonTestServiceImpl implements CommonTestService {

	@Async
	@Override
	public void asyncTest(List<Integer> ids) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ids.add(3);
	}

	@Override
	public void syncTest(List<Integer> ids) {
		ids.add(3);
	}
}
