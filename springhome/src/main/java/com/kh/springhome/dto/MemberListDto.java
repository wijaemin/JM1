package com.kh.springhome.dto;

import lombok.Data;

@Data
public class MemberListDto {
 private String memberId, memberNickname, memberContact;
 private String memberEmail, memberBirth, memberLevel;
}
