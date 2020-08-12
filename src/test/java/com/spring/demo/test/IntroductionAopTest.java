package com.spring.demo.test;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/10 23:37
 * @Version: 1.0
 */

import com.spring.demo.framework.aop.service.PersonService;
import com.spring.demo.framework.aop.service.WomenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntroductionAopTest {

	@Autowired
	private WomenService womenService;

	@Test
	public void test() {
		womenService.makeUp();
		PersonService ps = (PersonService)womenService;
		ps.eat();
	}
}
