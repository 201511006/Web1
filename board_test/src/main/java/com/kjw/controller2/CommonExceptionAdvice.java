package com.kjw.controller2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //호출되는 메소드에서 발생된 Exception을 모두 처리하는 역할!
public class CommonExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView common(Exception ex){
		
//		logger.info(ex.toString());
		
		ModelAndView modelAndView = new ModelAndView(); //하나의 객체에 model데이터와 view의 처리를 동시에 할 수 있는 객체
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", ex);
		
		return modelAndView;
	}
}
