package com.wjm.springpractice.dto;

import lombok.Data;


@Data//@Setter+@Getter+@ToString+@EqualsAndHashCode

//@Setter @Getter @NoArgsConstructor @ToString
public class PocketmonDto {
	private int no;
	private String name;
	private String type;
	private boolean image;//이미지유무 = DB미포함
}
