package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class NewTest01Ready {
	
	@Test
	public void test() throws URISyntaxException {
	//전송 도구 생성
	RestTemplate template = new RestTemplate();
	//주소 설정
	URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
	//헤더 설정
	HttpHeaders headers = new HttpHeaders();
	headers.set("Authorization", "SECRET_KEY DEV82025B6BFC14EE02C2C24CA4D3487E7877677");
	headers.set("Content-type", "application/json");
	
	Map<String, String> body = new HashMap<>();
	body.put("cid", "TC0ONETIME");
	body.put("partner_order_id", UUID.randomUUID().toString());//시리얼 랜덤번호 생성
	body.put("partner_user_id", "minialp2002");
	body.put("item_name", "아이스 아메리카노");
	body.put("quantity", "1");
	body.put("total_amount", "3000");
	body.put("tax_free_amount", "0");
	body.put("approval_url", "http://localhost:8080/pay/success");
	body.put("cancel_url", "http://localhost:8080/pay/cancel");
	body.put("fail_url", "http://localhost:8080/pay/fail");
	
	//요청 발송
	HttpEntity entity = new HttpEntity(body, headers);
	
	
	Map response = template.postForObject(uri, entity, Map.class);
	log.debug("url={}", response.get("next_redirect_pc_url"));
	}

}
