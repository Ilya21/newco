package com.andreitop.newco.aspect;


import com.andreitop.newco.dto.TripDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
    private static final String MARKER = " -----> ";
    @Before("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void beforeRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(MARKER + " Method " + className + "." + methodName + " is about to be called");
    }


    @AfterReturning("com.andreitop.newco.aspect.PointcutContainer.repositorySave()")
    public void afterReturningRepoSave(JoinPoint joinPoint){
        TripDto tripDto = (TripDto) (joinPoint.getArgs()[0]);
        logger.info(MARKER + tripDto + " saved");
    }

    @Around("com.andreitop.newco.aspect.PointcutContainer.serviceMethods()")
    public Object aroundServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(MARKER + joinPoint.getSignature().getName() + " --- Before call method in service");

        Object result = joinPoint.proceed();

        logger.info(MARKER + joinPoint.getSignature().getName() + " --- After call method in service");

        return result;
    }

    @After("com.andreitop.newco.aspect.PointcutContainer.controllerMethods()")
    public void afterControllerMethods(JoinPoint joinPoint){
        Object pointTarget = joinPoint.getTarget();
        Object pointThis = joinPoint.getThis();
        logger.info(MARKER + "Some controller method was called. Target: " + pointTarget + ". This: " + pointThis);
    }

    @AfterThrowing(pointcut = "com.andreitop.newco.aspect.PointcutContainer.throwingExc()", throwing = "exception")
    public void throwingExc(JoinPoint joinPoint, Exception exception){
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(MARKER + "Method " + className + "." + methodName + " threw exception with message " + exception.getMessage());
    }


}
