package springAOPAspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	/** Following is the definition for a PointCut to select
	    *  all the methods available. So advice will be called
	    *  for all the methods.
	    */
	   //@Pointcut("execution(* springAOPAspectj.CustomerBoImpl.*(..))")
	   private void selectGetAge(){}

	   /** 
	    * This is the method which I would like to execute
	    * before a selected method execution.
	    */
	   //@Before("selectGetAge()")
	   public void beforeAdvice(){
		   System.out.println("Going to setup student profile.");
	   }  
	   
	   //@Around("execution(* springAOPAspectj.CustomerBoImpl.*(..))")
	   @Around("@annotation(springAOPAspectj.Profiling)")
		public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
			System.out.println("Before invoking getName() method");
			Object value = null;
			try {
				value = proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			System.out.println("After invoking getName() method. Return value="+value);
			return value;
		}
}