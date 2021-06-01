package js.toy.vocabulary.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 서비스 예외처리 Aspect
 */
@Slf4j
@Component
@Aspect
public class ServiceExceptionAspect {

    /**
     * 서비스 예외처리 Aspect
     *
     * @param proceedingJoinPoint the proceeding join point
     * @return the object
     */
    // 범위 설정 execution(* js.toy.vocabulary.service.*.*(..))
    @Around("execution(* js.toy.vocabulary.service.*.*(..))")
    public Object serviceExceptionHandler(ProceedingJoinPoint proceedingJoinPoint){
        try {
            return proceedingJoinPoint.proceed();

        // Throwable 은 Exception 보다 상위 클래스이므로 모든 예외를 잡습니다.
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
