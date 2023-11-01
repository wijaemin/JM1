package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01Ready {
	
	@Test
	public void test() throws URISyntaxException {
		//웹서버에서 PG사(제3의 서버)로 요청을 보내기 위해선 다음 둘 중 하나가 필요
		//[1] RestTemplate
		//[2] WebClient
		
		//전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK e60c29123e01626cdd927fc40aec9596");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("partner_order_id", UUID.randomUUID().toString());//시리얼 랜덤번호 생성
		body.add("partner_user_id", "testuser1");
		body.add("item_name", "아이스 아메리카노");
		body.add("quantity", "1");
		body.add("total_amount", "3000");
		body.add("tax_free_amount", "0");
		body.add("approval_url", "http://localhost:8080/pay/success");
		body.add("cancel_url", "http://localhost:8080/pay/cancel");
		body.add("fail_url", "http://localhost:8080/pay/fail");
		
		//요청 발송
//		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body,headers);
		HttpEntity entity = new HttpEntity(body, headers);
		
		Map response = template.postForObject(uri, entity, Map.class);
//		log.debug("response={}",response);
				
		log.debug("url={}", response.get("next_redirect_pc_url"));
		
		
		
	}
}
