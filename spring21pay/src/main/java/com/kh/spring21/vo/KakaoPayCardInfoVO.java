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
public class KakaoPayCardInfoVO {
//	private String purchaseCorp, purchaseCorpCode;
//	private String issuerCorp, issuerCorpCode;
//	private String kakaopayPurchaseCorp, kakaopayPurchaseCorpCode;
//	private String kakaopayIssuerCorp, kakaopayIssuerCorpCode;
//	private String bin;
//	private String cardType, installMonth, approvedId;
//	private String cardMid, interestFreeInstall, cardItemCode;
	
	
	private String kakaopayPurchaseCorp, kakaopayPurchaseCorpCode;
	private String kakaopayIssuerCorp, kakaopayIssuerCorpCode;
	private String bin;
	private String cardType, installMonth, approvedId;
	private String cardMid, interestFreeInstall;
	private String installmentType, cardItemCode;
	
	
}
