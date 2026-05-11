/**package se.yrgo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CustomerServicePerformanceAdvice {
    @Before("execution(* se.yrgo.services.customers.*.*(..)) || execution(* se.yrgo.data.customers.*.*(..))")
    public void methodLogging(JoinPoint method) throws Throwable{
        System.out.println("Now executing method: " + method.getSignature().getName() +
                " from the class " + method.getSignature().getDeclaringTypeName());
    }
    @Before("execution(* se.yrgo.data.customers.*.create*(..))")
    public void databaseLogging(JoinPoint method) throws Throwable{
        if(method.getSignature().getName().equals("createCustomer")){
            System.out.println("Now adding new customer to the database");
        }
        else if(method.getSignature().getName().equals("createInvoice")){
            System.out.println("Now adding new invoice to the database");
        }
    }
    @Around("execution(* se.yrgo.services.customers.*.*(..)) || execution(* se.yrgo.data.customers.*.*(..))")
    public Object performanceTiming(ProceedingJoinPoint method) throws Throwable {
        double startTime = System.nanoTime();
        try {
            Object value = method.proceed();
            return value;
        }
        finally {
            double finishTime = System.nanoTime();
            double totalTime = finishTime - startTime;
            System.out.println("Execution of method " + method.getSignature().getName() + " took " + totalTime/1000000 + " ms");
        }
    }
}*/