package com.wjm.springpractice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wjm.springpractice.interceptor.BoardDefenderInterceptor;
import com.wjm.springpractice.interceptor.BoardOwnerInterceptor;
import com.wjm.springpractice.interceptor.MemberInterceptor;
import com.wjm.springpractice.interceptor.TestInterceptor;



/*
  
  	스프링에서 제공하는 설정파일
	- application.properties에서 설정할 수 없는 내용들을 설정하는 파일
	
	만드는 법
	1. 등록(@Configuration)
	2. 필요 시 상속(WebMvcConfigurer)
	3. 상황에 맞는 메소드 재정의 및 코드 작성
  
  
  
*/

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Autowired
	private BoardOwnerInterceptor boardOwnerInterceptor;
	
	@Autowired
	private BoardDefenderInterceptor boardDefenderInterceptor;
	
	//인터셉터를 추가할 수 있는 설정 메소드(registry 저장소에 설정)
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//testInterceptor를 모든 주소 처리 과정에 간섭할 수 있도록 설정
		registry.addInterceptor(testInterceptor)
				.addPathPatterns("/**"
						);
		
		//비회원 차단
		registry.addInterceptor(memberInterceptor)
				.addPathPatterns("/member/**",
						"/board/**"
						)
				.excludePathPatterns(
						"/member/join",
						"/member/joinFinish",
						"/member/login",
						"/member/exitFinish",
						"/board/list",
						"/board/detail"
						);
		
		//게시글 소유자 외의 접근 차단
		registry.addInterceptor(boardOwnerInterceptor)
				.addPathPatterns("/board/edit","/board/delete");
		
		
		//게시글 조회 수 중복방지
		registry.addInterceptor(boardDefenderInterceptor)
				.addPathPatterns("/board/detail");
	}
}
