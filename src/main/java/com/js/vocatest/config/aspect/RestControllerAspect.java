package com.js.vocatest.config.aspect;

import com.js.vocatest.config.response.RestResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * The type Rest controller aspect.
 */
@Aspect
@Component
public class RestControllerAspect {

    /**
     * Rest response handler rest response.-
     *
     * @param proceedingJoinPoint the proceeding join point
     * @return the rest response
     * @throws Throwable the throwable
     */
    @Around("execution(* com.js.vocatest.controller.*.*(..))")
    public RestResponse<Object> restResponseHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return new RestResponse<>(HttpStatus.OK.value(), "OK", proceedingJoinPoint.proceed());
    }

}
