package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.kh.spring21.configuration.KakaoPayProperties;
import com.kh.spring21.configuration.NewKakaoPayProperties;
import com.kh.spring21.vo.KakaoPayReadyRequestVO;
import com.kh.spring21.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class NewTest04Ready {

	@Autowired
	private NewKakaoPayProperties newKakaoPayProperties;
	
	
	@Test
	public void test() throws URISyntaxException {
		//변하는 정보와 중요한 정보들을 분리하여 모듈로 개발
		
		//결제 준비 요청 정보를 클래스로 모듈화
		KakaoPayReadyRequestVO request = KakaoPayReadyRequestVO.builder()
				.partnerOrderId(UUID.randomUUID().toString())
				.partnerUserId("minialp2002")
				.itemName("초코파이 1box")
				.itemPrice(3500)
				.build();
		
		//전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//(+추가) SNAKE_CASE를 CAMEL_CASE로 처리하도록 추가 도구를 설정
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//		MappingJackson2CborHttpMessageConverter converter = new MappingJackson2CborHttpMessageConverter();
//		converter.setObjectMapper(mapper);
//		
//		template.getMessageConverters().add(0,converter);
		
		//주소 설정
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "SECRET_KEY DEV82025B6BFC14EE02C2C24CA4D3487E7877677");
		headers.set("Content-type", "application/json");
			
		Map<String, String> body = new HashMap<>();
		body.put("cid", newKakaoPayProperties.getCid());
		body.put("partner_order_id", request.getPartnerOrderId());//시리얼 랜덤번호 생성
		body.put("partner_user_id",  request.getPartnerUserId());
		body.put("item_name", request.getItemName());
		body.put("quantity", "1");
		body.put("total_amount",String.valueOf(request.getItemPrice()));
		body.put("tax_free_amount", "0");
		body.put("approval_url", "http://localhost:8080/pay/success");
		body.put("cancel_url", "http://localhost:8080/pay/cancel");
		body.put("fail_url", "http://localhost:8080/pay/fail");
		
		//요청 발송
//		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body,headers);
		HttpEntity entity = new HttpEntity(body, headers);
		
//		Map response = template.postForObject(uri, entity, Map.class);
		KakaoPayReadyResponseVO response = 
				template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		log.debug("response={}",response);
				
//		log.debug("url={}", response.getNext_redirect_pc_url());
		
		//다음 테스트를 위해 필요한 값을 출력
		log.debug("결제 페이지 ={}",response.getNextRedirectPcUrl());
		log.debug("tid ={}",response.getTid());
		log.debug("partner_order_id ={}",request.getPartnerOrderId());
		log.debug("partner_user_id={}",request.getPartnerUserId());
		
		
	}
}
