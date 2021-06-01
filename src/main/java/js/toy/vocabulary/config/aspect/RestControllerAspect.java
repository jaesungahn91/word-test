package js.toy.vocabulary.config.aspect;

import js.toy.vocabulary.config.response.RestResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 컨트롤러 전역 Aspect
 */
@Aspect
@Component
public class RestControllerAspect {

    /**
     * 컨트롤러 전역 Aspect
     *
     * @param proceedingJoinPoint the proceeding join point
     * @return the rest response
     * @throws Throwable the throwable
     */
    // 범위 설정 execution(* js.toy.vocabulary.controller.*.*(..))
    @Around("execution(* js.toy.vocabulary.controller.*.*(..))")
    public RestResponse<Object> restResponseHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return new RestResponse<>(HttpStatus.OK.value(), "OK", proceedingJoinPoint.proceed());
    }

}
