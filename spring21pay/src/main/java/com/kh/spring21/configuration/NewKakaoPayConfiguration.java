package com.kh.spring21.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

//카카오페이 서버와 통신을 위해 필요한 객체를 등록해두는 파일(RestTemplate, HttpHeaders)
@Configuration
public class NewKakaoPayConfiguration {
	
	@Autowired
	private NewKakaoPayProperties newKakaoPayProperties;
	
	@Bean
	public RestTemplate template() {
		RestTemplate template = new RestTemplate();
		return template;
	}
	@Bean
	public HttpHeaders headers() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "SECRET_KEY "+newKakaoPayProperties.getKey());
		headers.add("Content-type", "application/json");
		return headers;
	}
	
}
