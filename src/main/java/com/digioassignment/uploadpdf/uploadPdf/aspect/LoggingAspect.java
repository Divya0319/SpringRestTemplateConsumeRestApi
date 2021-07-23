package com.digioassignment.uploadpdf.uploadPdf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.digioassignment.uploadpdf.uploadPdf.entity.request.UploadPdfRequest;
import com.digioassignment.uploadpdf.uploadPdf.entity.response.UploadPdfResponse;

@Component
@Aspect
public class LoggingAspect {
	
	private Logger myLogger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(* com.digioassignment.uploadpdf.uploadPdf.rest.UploadPdfRestController.*(..))")
	private void forAnyMethodInRestController() {}
	
	@Pointcut("execution(* com.digioassignment.uploadpdf.uploadPdf.rest.UploadPdfRestController.getDocumentDetails(..))")
	private void forGetDocumentDetails() {}
	
	@Pointcut("execution(* com.digioassignment.uploadpdf.uploadPdf.rest.UploadPdfRestController.uploadPdf(..))")
	private void forUploadPdf() {}
	
	@Before("forAnyMethodInRestController()")
	public void beforeCallingMethod(JoinPoint theJoinPoint) {
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("------->>> Calling method : " + methodSig.toShortString());
		
		Object args[] = theJoinPoint.getArgs();
		
		for( Object arg : args) {
			
			if(arg instanceof UploadPdfRequest) {
				
				UploadPdfRequest request = (UploadPdfRequest)arg;
				
				myLogger.info("------->>> Request Body : " + request.toString());
				
			} else if(arg instanceof String) {
				
				myLogger.info("----->> Param : " + arg.toString());
			}
			
			
		}
		
	}
	
	@AfterReturning(pointcut = "forGetDocumentDetails() || forUploadPdf()", returning = "response")
	public void afterReturningOfGetDocumentOrUploadPdf(JoinPoint theJoinPoint, UploadPdfResponse response) {
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("------->>> Response : " + response.toString());
		
		myLogger.info("------->>> Coming out of : " + methodSig.toShortString());
		
	}
}
