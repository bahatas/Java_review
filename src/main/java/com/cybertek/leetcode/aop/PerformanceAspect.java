package com.cybertek.leetcode.aop;




//
//@Aspect
//@Configuration
//@Slf4j
public class PerformanceAspect {

}
//
//
//
//    @Pointcut("@annotation(com.cybertek.aspects.MethodExecutionTime)")
//    private void anyExecutionTimeOperation(){
//
//
//    }
//
//    @Around("anyExecutionTimeOperation()")
//    public Object anyExecutionTimeOperationAdvice(ProceedingJoinPoint proceedingJoinPoint)  {
//
//        long beforeTime = System.currentTimeMillis();
//        Object result = null;
//
//        try {
//            result = proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//        long afterTime = System.currentTimeMillis();
//
//        log.info("Time taken to execute : {} ms (Method : {} - Parameters : {}",(afterTime-beforeTime),proceedingJoinPoint.getSignature().toShortString(),proceedingJoinPoint.getArgs());
//
//        return result;
//    }
//}
