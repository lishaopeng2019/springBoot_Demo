package com.spring.demo.framework.aop.service.impl;

import com.spring.demo.framework.aop.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/10 23:27
 * @Version: 1.0
 */
@Component
@Slf4j
public class PersonServiceImpl implements PersonService {

	@Override
	public void eat() {
		log.info("人是铁,饭是钢,一天不吃饿得慌!");
	}
}
