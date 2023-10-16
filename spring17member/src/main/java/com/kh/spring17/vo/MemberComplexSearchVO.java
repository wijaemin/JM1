package com.kh.spring17.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberComplexSearchVO {
	private String memberId;
	private String memberNickname;
	private String memberContact;
	private String memberBirthBegin,memberBirthEnd;
	private Integer memberPointMin,memberPointMax;
	private String memberJoinBegin,memberJoinEnd;
	private List<String> memberLevelList;
	private List<String> orderList;
	private Integer begin;
	private Integer end;
	
	
}
