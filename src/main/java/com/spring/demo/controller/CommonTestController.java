package com.spring.demo.controller;

import com.spring.demo.service.CommonTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/9 16:13
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class CommonTestController {

	@Autowired
	private CommonTestService commonTestService;

	@GetMapping("/async")
	public List<Integer> asyncRequest() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		commonTestService.asyncTest(ids);
		ids.add(2);
		try {
			Thread.sleep(1000); // 睡会,以保证返回前台时异步方法中的3已入列
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ids;
	}

	@GetMapping("/sync")
	public List<Integer> syncRequest() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		commonTestService.syncTest(ids);
		ids.add(2);
		return ids;
	}
}
