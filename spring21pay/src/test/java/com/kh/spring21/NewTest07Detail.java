package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.configuration.NewKakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class NewTest07Detail {
	//간이 테스트
	@Autowired
	RestTemplate template;
	@Autowired
	HttpHeaders headers;
	@Autowired
	NewKakaoPayProperties newKakaoPayProperties;
	@Test
	public void test() throws URISyntaxException {
		URI uri =new URI("https://open-api.kakaopay.com/online/v1/payment/order");
		
		
//		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//		body.add("cid", newKakaoPayProperties.getCid());
//		body.add("tid", "T538760f51b66fd40843");
		
		Map<String,String> body= new HashMap<>();
		body.put("cid", newKakaoPayProperties.getCid());
		body.put("tid", "T7073526058063935cf0");
		
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response={}",response);
	}
	
}
