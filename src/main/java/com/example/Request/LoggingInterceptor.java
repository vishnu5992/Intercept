package com.example.Request;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.Request.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;



@Component
public class LoggingInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Override
	public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,Object> inputMap = new ObjectMapper().readValue(request.getInputStream(), Map.class);
		
		logger.info("Incoming request is " + inputMap);
		logger.info("Incoming url is: "+ request.getRequestURL());
		System.out.println("PreHandle Method is called()");
		return false;
	}
	
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable ModelAndView modelAndView) throws Exception{
//		
//	}
//
//	
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable Exception ex) throws Exception {
//		
//	}

	
	
	
	
}
