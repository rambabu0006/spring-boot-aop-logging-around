package com.example.log.demo.logback.configuration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
//@EnableAspectJAutoProxy
@Aspect
public class TimeLogAspect {

	private final Logger logger = LoggerFactory.getLogger("analytics");

	/*	@Before(value = "execution(* com.javainuse.service.EmployeeService.*(..)) and args(name,empId)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Creating Employee with name - " + name + " and id - " + empId);
	}

	@Around(value = "execution(* com.javainuse.service.EmployeeService.*(..)) and args(name,empId)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}
	 */	
	//@Around("@annotation(com.nibado.example.springaop.aspects.Timed) && execution(public * *(..))")
	//execution(* com.abc.xyz..service..*(..)) ||
	@Around(value = "execution(String com.example.log.demo.logback.controller.*.*(..)) and args(name,..)")
	//@Around(value = "execution(* String com.example.log.demo.logback.controller.*.*(..))")
	//public Object methodExecutionTimeLog(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	public Object methodExecutionTimeLog(final ProceedingJoinPoint proceedingJoinPoint,String name) throws Throwable {		
		long start = System.currentTimeMillis();
		Object value;
		try {			
			System.out.println("All Arguments "+proceedingJoinPoint.getArgs());
			value = proceedingJoinPoint.proceed();
			System.out.println("value is "+value);
		} catch (Throwable throwable) {
			throw throwable;
		} finally {
			long duration = System.currentTimeMillis() - start;

			logger.info(
					"{}.{} took {} ms",
					proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
					proceedingJoinPoint.getSignature().getName(),
					duration);
			System.out.println("methodExecutionTimeLog "+duration);
		}
		return value;
	}

	/*	@Pointcut(
			"execution(public String com.example.log.demo.logback.controller.*)"
			)
	public void monitor() { }

	@Bean
	public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
		return new PerformanceMonitorInterceptor(true);
	}

	@Bean
	public Advisor performanceMonitorAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("com.example.log.demo.logback.configuration.AopConfiguration.monitor()");
		return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
	}*/

	/*@Bean
public Person person(){
return new Person("John","Smith", LocalDate.of(1980, Month.JANUARY, 12));
	}

@Bean
public PersonService personService(){
return new PersonService();
	}
	 */
}