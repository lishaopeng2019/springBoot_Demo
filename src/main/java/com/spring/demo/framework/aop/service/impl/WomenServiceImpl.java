package com.spring.demo.framework.aop.service.impl;

import com.spring.demo.framework.aop.service.WomenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/10 23:29
 * @Version: 1.0
 */
@Component
@Slf4j
public class WomenServiceImpl implements WomenService {

	@Override
	public void makeUp() {
		log.info("女为悦己者容。");
	}
}
