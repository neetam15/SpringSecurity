package demo.learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

	@Before("execution(* demo.learn.controllers.AppController.adminPg(..))")
	public void performBefore(JoinPoint joinPoint){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>In Aspect advice:-"+joinPoint.getSignature().getName());
	}
	
	@After("execution(* demo.learn.controllers.AppController.adminPg(..))")
	public void performAfter(JoinPoint joinPoint){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>In Aspect advice:-"+joinPoint.getSignature().getName());
	}
}
