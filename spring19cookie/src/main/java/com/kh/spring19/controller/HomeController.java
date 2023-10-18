package com.kh.spring19.controller;

import java.net.HttpCookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
//		return "/WEB-INF/views/home.jsp";//기존
		return "home";//View resolver 사용 후
	}
	/**
	 * 쿠키는 HttpCookie 클래스의 객체로 생성
	 * 생성 시 다음 정보를 설정할 수 있다
	 * - 이름(name), 값(value) 필수 설정
	 * - 만료시간(maxAge), 발행경로(path) 선택 설정 
	 */
	
	@RequestMapping("/create1")
	public String create1() {
		HttpCookie cookie = new HttpCookie("popup", "false");
		cookie.setMaxAge(Long.MAX_VALUE);
		return "redirect:/";
	}
}
