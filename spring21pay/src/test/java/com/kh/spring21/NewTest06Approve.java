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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.configuration.KakaoPayProperties;
import com.kh.spring21.configuration.NewKakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class NewTest06Approve {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpHeaders headers;
	
	@Autowired
	private NewKakaoPayProperties newKakaoPayProperties;
	
	@Test
	public void test() throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", newKakaoPayProperties.getCid());
		body.put("tid", "T70681eb058063935ad0");
		body.put("partner_order_id","ad32d3e7-a517-4b77-82db-58b8625e94ca");
		body.put("partner_user_id", "minialp2002");
		body.put("pg_token", "d5fec64d3d6e1108226a");
		
		HttpEntity entity = new HttpEntity(body,headers);
		
		Map response =template.postForObject(uri, entity, Map.class);
		log.debug("response={}",response);
	}
	
}
