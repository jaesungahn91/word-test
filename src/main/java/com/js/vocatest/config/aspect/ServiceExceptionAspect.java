package com.js.vocatest.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * The type Service exception aspect.
 */
@Component
@Aspect
public class ServiceExceptionAspect {

    /**
     * Service exception handler object.
     *
     * @param proceedingJoinPoint the proceeding join point
     * @return the object
     */
    @Around("execution(* com.js.vocatest.service.*.*(..))")
    public Object serviceExceptionHandler(ProceedingJoinPoint proceedingJoinPoint){
        try {
            return proceedingJoinPoint.proceed();

        // Throwable 은 Exception 보다 상위 클래스이므로 모든 예외를 잡습니다.
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
