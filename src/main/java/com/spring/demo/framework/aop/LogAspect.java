package com.spring.demo.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 日志切面类
 * @Version: 1.0
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

	/**
	 * 确定切入点位置,通过些规则来确定哪些方法是要增强的
	 */
	@Pointcut("within(com.spring.demo.controller.*Controller)") // controller包中所有Controller结尾的类
	public void controllerLogPointCut(){
	}

	/**
	 * 前置通知,具体的增强代码片
	 *
	 * @Param joinPoint 连接点
	 */
	@Before("controllerLogPointCut()")
    public void controllerBeforeLog(JoinPoint joinPoint) {
		// mvc获取请求的方式
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

		// 记录请求日志
		log.info("Request type is {}", request.getMethod());
		log.info("Request url is {}", request.getRequestURL());
		log.info("Target is {}", joinPoint.getTarget().getClass());
	}

	/**
	 * 后置通知,具体的增强代码片
	 *
	 * @Param returnResult 目标类方法的返回结果
	 */
	@AfterReturning(pointcut = "controllerLogPointCut()", returning = "returnResult")
	public void controllerAfterLog(Object returnResult) {
		// mvc获取响应的方式
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();

		log.info("Response status is {}, data is {}", response.getStatus(), returnResult.toString());
	}

	/**
	 * 异常时通知,具体的增强代码片
	 *
	 * @Param exception 目标类方法执行过程中出现的异常
	 */
	// @AfterThrowing(pointcut = "controllerLogPointCut()", throwing = "exception") // 方式1
	@AfterThrowing(pointcut = "execution(* com.spring.demo.controller.*.*(..))", throwing = "exception") // 方式2
	public void controllerAfterLog(Exception exception) {
		// mvc获取响应的方式
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

		log.info("Request url is {}", request.getRequestURL());
		log.info("Inner exception is {}", exception.getMessage());
	}
}
