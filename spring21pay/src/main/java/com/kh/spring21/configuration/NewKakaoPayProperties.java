package com.kh.spring21.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "new.custom.kakaopay")
public class NewKakaoPayProperties {
	private String cid, key;
}
