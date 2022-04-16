package com.nhnacademy.wbs.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    // TODO: 실행하는 스프링 빈의 모든 메소드의 실행시간을 elapse.log 파일에 저장하세요. (AOP 를 이용해야 합니다.)

    private static final Log log = LogFactory.getLog(LoggingAspect.class);

    @Around("execution(public * com.nhnacademy.wbs..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch(pjp.getSignature().getName());
        stopWatch.start(pjp.getSignature().getName());
        try {
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
        }
    }
}
