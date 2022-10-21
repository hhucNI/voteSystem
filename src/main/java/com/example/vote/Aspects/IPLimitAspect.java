//package com.example.vote.Aspects;
//
//import com.example.vote.Utils.Util;
//import com.sun.xml.internal.ws.client.ResponseContext;
//import lombok.extern.slf4j.Slf4j;
//import net.jodah.expiringmap.ExpirationPolicy;
//import net.jodah.expiringmap.ExpiringMap;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//
//@Aspect
//@Component
//@Slf4j
//public class IPLimitAspect {
////    private static ConcurrentHashMap<String, ExpiringMap<String, Integer>> book = new ConcurrentHashMap<>();
//
//    private static int MAX_TIMES=1;
//    /**
//     * 层切点
//     */
//    @Pointcut("execution(* com.example.vote.Utils.Util.triggerAop())")
//    public void controllerAspect() {
//    }
//
//    @Around("controllerAspect()")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//        // 获得request对象
//        System.out.println("------------------------AOP---------------------");
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
////        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        HttpServletResponse response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//
//        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//        HttpServletRequest request = sra.getRequest();
//        log.error("$$$$$本次请求IP为{}",request.getRemoteAddr());
//        log.error("$$$$$$本次请求URL为{}",request.getRequestURI());
//
////        HttpServletResponse response = null;
////        for (Object param : pjp.getArgs()) {
////            if (param instanceof HttpServletResponse) {
////                response = (HttpServletResponse) param;
////            }
////        }
////        assert response!=null;
//        // 获取Map value对象， 如果没有则返回默认值
//        // getOrDefault获取参数，获取不到则给默认值
//
//
////        request.getRequestURI() 这个应该是
////        ExpiringMap<String, Integer> uc = book.getOrDefault(request.getRequestURI(), ExpiringMap.builder().variableExpiration().build());
//        ExpiringMap<String, Integer> uc = ExpiringMap.builder().variableExpiration().build();
//
//
//        Integer uCount = uc.getOrDefault(request.getRemoteAddr(), 0);
//        long toTomorrow = Util.getTimeIntervalToTomorrow();
//
//        if (uCount >= MAX_TIMES) { // 超过次数，不执行目标方法
//            log.error("接口拦截：今天已投票,请明天再试，IP为{}",request.getRemoteAddr());
//            //TODO 测试请求转发，debug测试map
//            response.sendRedirect("hello.html");
//            return "请求过于频繁，请稍后再试";
//        } else if (uCount == 0) { // 第一次请求时，设置有效时间
//            log.error("IP  : {} 第一次请求",request.getRemoteAddr());
//
//            uc.put(request.getRemoteAddr(),  1, ExpirationPolicy.CREATED, toTomorrow, TimeUnit.MINUTES);
//        } else { // 未超过次数， 记录加一
//            uc.put(request.getRemoteAddr(), uCount + 1);
//        }
////        book.put(request.getRequestURI(), uc);
//
//        // result的值就是被拦截方法的返回值
//        Object result = pjp.proceed();
//
//        return result;
//    }
//}
