package com.kh.spring21.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentDto {
	private int paymentNo;
	private String paymentMember;
	private int paymentProduct;
	private String paymentTid;
	private String paymentName;
	private int paymentPrice;
	private Date paymentTime;
	
}
