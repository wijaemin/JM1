package com.kh.spring21.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIgnoreProperties({"tms_result"})//특정 항목만 무시하도록 지정
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown =true)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayReadyResponseVO {
	private String tid;//결제 고유번호
//	private String next_redirect_app_url;//모바일 앱용 결제 페이지 주소
	private String nextRedirectAppUrl;//모바일 앱용 결제 페이지 주소
//	private String next_redirect_mobile_url;//모바일 웹용 결제 페이지 주
	private String nextRedirectMobileUrl;//모바일 웹용 결제 페이지 주
//	private String next_redirect_pc_url;//PC 웹용 결제 페이지 주소
	private String nextRedirectPcUrl;//PC 웹용 결제 페이지 주소
//	private String android_app_scheme;//카카오페이 결제를 위한 안드로이드 스키마
	private String androidAppScheme;//카카오페이 결제를 위한 안드로이드 스키마
//	private String ios_app_scheme;//카카오페이 결제를 위한 아이폰 스키마
	private String iosAppScheme;//카카오페이 결제를 위한 아이폰 스키마
//	private Date created_at;//결제 준비를 요청한 시각
	private Date createdAt;//결제 준비를 요청한 시각
	
}
