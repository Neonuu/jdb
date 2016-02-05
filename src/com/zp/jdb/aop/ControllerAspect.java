package com.zp.jdb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ControllerAspect {

	@Pointcut("within(com.zp.jdb.controller..*)")
	public void mypoint(){}
	
	@Before("mypoint()")
	public void mybefore(){
		System.out.println("����Controller����");
	}
	
}
