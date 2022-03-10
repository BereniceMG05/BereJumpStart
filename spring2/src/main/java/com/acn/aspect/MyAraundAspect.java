package com.acn.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//import java.util.logging.Logger;

@Component  // define as  bean
@Aspect // define as  aspect
public class MyAraundAspect {

    private final Logger logger = LogManager.getLogger(this.getClass());

    //define as pointcut
   @Pointcut("execution(public String com.acn.GreetingServiceImpl.getGreeting(String))")
   protected void mypoint() {
   }

    @Around("mypoint()")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        String calledMethod = proceedingJoinPoint.getSignature().getName();
        Object returnValue = null;
        System.out.println("calledMethod: " + calledMethod);
        logger.info("calledMethod: " + calledMethod);
        try {
            returnValue = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
        //    e.printStackTrace();
            logger.error(e);
        }
        logger.info("And the return was: " + returnValue);
        return returnValue;
    }
}
