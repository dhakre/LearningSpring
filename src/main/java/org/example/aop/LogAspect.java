package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

@Component
@Aspect
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(Logging)")
    public void executeLog(){}



    @Before("executeLog()")
    public void logMethodBefore(JoinPoint joinPoint){

        LOGGER.info("Before advice method called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value ="executeLog()", returning = "returnObject")
    public void logMethodAfter(JoinPoint joinPoint, Object returnObject){
        StringBuilder returnMessage =  new StringBuilder("After advice method: ");
        returnMessage.append(joinPoint.getSignature().getName()).append(" ,returning value:");
        if(returnObject instanceof Collection){
            returnMessage.append(((Collection<?>)returnObject).size());
        } else {
            returnMessage.append(returnObject.toString());
        }

        LOGGER.info(returnMessage.toString());
    }

    @Around(value ="executeLog()")
    public Object logMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnObject = joinPoint.proceed();
        long end= System.currentTimeMillis()-start;
        StringBuilder returnMessage =  new StringBuilder("Around advice : ");
        returnMessage.append(joinPoint.getSignature().getName()).append(" ,returning value:");
        if(returnObject instanceof Collection){
            returnMessage.append(((Collection<?>)returnObject).size());
        } else {
            returnMessage.append(returnObject.toString());
        }
        returnMessage.append(", Total around time: ").append(end).append(" ms");

        LOGGER.info(returnMessage.toString());
        return returnObject;
    }

}
