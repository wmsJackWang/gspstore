package JDKWebFrame.jobs.quartzs.dynaticquartz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class QuartzAspect {

	@Pointcut("execution(public * JDKWebFrame.jobs.quartzs.dynaticquartz.service.impl.QuartzServiceImpl.datagrid(..))")
	public void anyMethod(){}
	
	@Before("anyMethod()")
	public void doCheckBefore(){
		System.out.println("前置通知");
	}
	@After("anyMethod()")
	public void doCheckAfter(){
		System.out.println("定义最终通知");
	}
	@Around("anyMethod()")
	public Object around(ProceedingJoinPoint joinPoint){
		System.out.println("环绕通知");
		Object result = null;
		try {
				result = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@AfterReturning(pointcut = "anyMethod()")
	public void doAfterReturnAdvice(){
		System.out.println("定义后置通知");
	}
	@AfterThrowing(pointcut = "anyMethod()",throwing = "ex")
	public void doAfterThrowing(Exception ex){
		System.out.println("定义例外通知");
	}
	
}
