package com.kh.springhome.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 컨트롤러를 간섭하여 예외 상황을 다르게 처리하도록 하는 객체
 * - 등록 시 @ControllerAdvice 라고 등록
 * - @RestController 를 간섭할 경우는 @RestControllerAdvice를 사용
 *
 */
//@ControllerAdvice(basePackages = {"com.kh.springhome.controller"})
@ControllerAdvice(annotations = {Controller.class} )
public class ExceptionControllerAdvice {
	/**
	 * 예외는 @ExceptionHandler 메소드로 처리 가능
	 * - 처리할 예외의 종류 지정 가능
	 * - 메소드의 형태는 컨트롤러와 같음
	 * - try구문의 catch 블록과 같은 역할을 수행
	 * - 이 메소드에는 컨트롤러처럼 매개변수를 선언하면 사용할 수 있다.
	 *		-Model, HttpSession 등 기본적인 컨트롤러의 도구 사용 가능
	 *		-catch 처럼 예외 처리 객체를 선언할 수 있다
	 */
	@ExceptionHandler(Exception.class)
	public String error(Exception e) {
		e.printStackTrace();
		return "/WEB-INF/views/error/500.jsp";
	}
	

}











