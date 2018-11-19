package com.netive.service.common.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class CommonAcpect {

	private final Logger logger = LoggerFactory.getLogger(CommonAcpect.class);
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : SPRING AOP, 실행 시간을 측정 하는 매서드(RUN TIME SAVE....)
	 * */		
	@Around("execution(* com.netive.service..*DAO.*(..))")
	public Object commonAround(ProceedingJoinPoint jp) throws Throwable {
		
		StopWatch s = new StopWatch();			//SPRING에서 제공 되는 STOPWATCH OBJECT
		
		s.start();								//STOPWATCH START
		Object obj = jp.proceed();
		s.stop();								//STOPWATCH STOP
		
		double t = s.getTotalTimeSeconds();
		
		logger.info("[ExecutionTime] " + jp.getTarget().getClass().getName()+"."+jp.getSignature().getName() + " , " + t + "(ms)");

		return obj;
	}
	
	@After("execution(* com.netive.service..*DAOImpl.*(..))")
	public void commonAfter() {
	}
	
	@Before("execution(* com.netive.service..*DAOImpl.*(..))")
	public void commonBefore() {
	}		
	
	@AfterReturning("execution(* com.netive.service..*DAOImpl.*(..))")
	public void commonReturning() {
	}		
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : SPRING AOP, 예외 발생시 실행 되는 메서드 (EXCEPTION LOG SAVE....)
	 * */ 		
	@AfterThrowing(value="execution(* com.netive.service..*DAOImpl.*(..))", throwing="ex")
	public void commonThrowing(Exception ex) {
		logger.info("[Execution] ========================================================================");
		//logger.info("[Execution] " + ex.getMessage());
	}	
		
}
