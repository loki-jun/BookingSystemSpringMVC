package edu.ustc.highfly.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerHandler {
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("exception", e);
		return mav;
	}
}
