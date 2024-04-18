package com.wjm.springpractice.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(basePackages = {"com.wjm.springpractice.controller"})
@ControllerAdvice(annotations = {Controller.class})
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String error(Exception e) {
		e.printStackTrace();
		return "/WEB-INF/views/error/500.jsp";
	}
	
	@ExceptionHandler(NoTargetException.class)
	public String noTarget(NoTargetException e) {
//		e.printStackTrace();// 굳이 찍을 필요 x
		return "/WEB-INF/views/error/noTarget.jsp";
	}
	@ExceptionHandler(AuthorityException.class)
	public String Authority(AuthorityException e) {
		e.printStackTrace();
		return "/WEB-INF/views/error/authority.jsp";
	}
}
