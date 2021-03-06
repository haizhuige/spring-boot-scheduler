package com.neo.task;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neo.bo.SysSchedule;
import com.neo.dao.SysScheduleMapper;

@Aspect  
@Component 
public class LogAspect {
	@Autowired
	SysScheduleMapper scheduleMapper;
	    @Pointcut("execution(public * com.neo.task..SchedulerTask.process(..))")  
	    public void webLog(){}  
	    @Before("webLog()")  
	    public void deBefore(JoinPoint joinPoint) throws Throwable {  
	    	System.out.println("开始前方法执行。。。。"); 
	        // 接收到请求，记录请求内容  
	     //   ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
	     //   HttpServletRequest request = attributes.getRequest();  
	        // 记录下请求内容  
	      //  System.out.println("URL : " + request.getRequestURL().toString());  
	     //   System.out.println("HTTP_METHOD : " + request.getMethod());  
	    //    System.out.println("IP : " + request.getRemoteAddr());  
	    //    System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
	     //   System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs())); 
	    }
	    @AfterReturning(returning = "ret", pointcut = "webLog()")  
	    public void doAfterReturning(Object ret) throws Throwable {  
	        // 处理完请求，返回内容  
	        System.out.println("方法的返回值 : " + ret);  
	    }  
	    //后置异常通知  
	    @AfterThrowing("webLog()")  
	    public void throwss(JoinPoint jp){  
	        System.out.println("方法异常时执行.....");  
	    }  
	    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行  
	    @After("webLog()")  
	    public void after(JoinPoint jp){  
	        System.out.println("方法最后执行.....");  
	        SysSchedule schedule=new SysSchedule();
	        schedule.setExcuteTime(new Date());
	        schedule.setFlag("1");
	        schedule.setTaskName("process");
	        scheduleMapper.insert(schedule);
	    } 
	  //环绕通知,环绕增强，相当于MethodInterceptor  
	    @Around("webLog()")  
	    public Object arround(ProceedingJoinPoint pjp) {  
	        System.out.println("方法环绕start.....");  
	        try {  
	            Object o =  pjp.proceed();  
	            System.out.println("方法环绕proceed，结果是 :" + o);  
	            return o;  
	        } catch (Throwable e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
}
