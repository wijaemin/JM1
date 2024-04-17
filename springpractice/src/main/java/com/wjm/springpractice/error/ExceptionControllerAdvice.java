package com.wjm.springpractice.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(basePackages = {"com.wjm.springpractice.controller"})
@ControllerAdvice(annotations = {Controller.class})
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String error() {
		return "/WEB-INF/views/error/500.jsp";
	}
}
