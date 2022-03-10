package com.acn.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//import java.util.logging.Logger;

//@Component  // define as  bean
//@Aspect // define as  aspect
public class MyAspect {

    private final Logger logger = LogManager.getLogger(this.getClass());

    //define as pointcut
   @Pointcut("execution(public String com.acn.GreetingServiceImpl.getGreeting(String))")
   protected void mypoint() {
   }

    @Before("mypoint()")
    public void myBeforeAdvice(JoinPoint joinPoint) {
        String calledMethod = joinPoint.getSignature().getName();

        if (logger.isInfoEnabled()) {
            logger.info("calledMethod: " + calledMethod);
        }

        System.out.println("calledMethod: " + calledMethod);
    }

}
