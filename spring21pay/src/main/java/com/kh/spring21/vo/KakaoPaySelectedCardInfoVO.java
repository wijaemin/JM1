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
public class KakaoPaySelectedCardInfoVO {
	private String cardBin;
	private int installMonth;
	//추가됨
	private String installmentType;
	private String cardCorpName, interestFreeInstall;
}
