package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Aspect
public class CountMethodCallsAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountMethodCallsAspect.class);

    @Pointcut("@annotation(CountMethodCalls)")
    public void countMethodCalls(){}

    @Around(value ="countMethodCalls()")
    public Object callMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        int count=0;
        Object returnObject = joinPoint.proceed();
        count++;
        StringBuilder returnMessage =  new StringBuilder("Around advice : ");
        returnMessage.append(joinPoint.getSignature().getName()).append(" ,returning value:");
        if(returnObject instanceof Collection){
            returnMessage.append(((Collection<?>)returnObject).size());
        } else {
            returnMessage.append(returnObject.toString());
        }
        returnMessage.append(", Total method calls: ").append(count);

        LOGGER.info(returnMessage.toString());
        return returnObject;
    }
}
