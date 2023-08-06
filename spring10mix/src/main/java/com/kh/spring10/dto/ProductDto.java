package com.kh.spring10.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductDto {
	private int no;
	private String name;
	private String type;
	private int price;
	private Date made;
	private Date expire;
}
