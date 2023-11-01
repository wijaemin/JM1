package com.kh.spring21.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown =true)
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class KakaoPayPaymentActionDetailVO {
	private String aid, approvedAt;
	private int amount, pointAmount, distcountAmount, greenDeposit;
	private String paymentActionType, payload;
}
