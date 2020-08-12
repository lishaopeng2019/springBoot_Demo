package com.spring.demo.framework.aop;

import com.spring.demo.framework.aop.service.PersonService;
import com.spring.demo.framework.aop.service.impl.PersonServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/10 22:49
 * @Version: 1.0
 */

@Aspect
@Component
public class IntroductionAop {

	@DeclareParents(value = "com.spring.demo.framework.aop.service.impl.*", defaultImpl = PersonServiceImpl.class)
	public PersonService personService;
}
