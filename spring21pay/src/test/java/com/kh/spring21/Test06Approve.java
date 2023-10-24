package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.configuration.KakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test06Approve {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpHeaders headers;
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	@Test
	public void test() throws URISyntaxException {
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());
		body.add("tid", "T53769172b8b1abb00ac");
		body.add("partner_order_id","5f33cd82-7ddd-419e-a4a5-d491cdabbf75");
		body.add("partner_user_id", "testuser1");
		body.add("pg_token", "beb08a592ce8d24b7688");
		
		HttpEntity entity = new HttpEntity(body,headers);
		
		Map response =template.postForObject(uri, entity, Map.class);
		log.debug("response={}",response);
	}
	
}
