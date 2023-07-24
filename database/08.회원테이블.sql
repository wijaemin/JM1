/*
다음 요구사항에 따라 회원(member) 테이블을 구현하시오.

테이블 항목
- 회원 아이디(member_id)
  - 다른 회원들과 중복되지 않는 고유한 값
  - 영문 소문자로 시작해야 함
  - 영문 소문자와 숫자로 이루어진 8~25글자를 가짐
- 회원 비밀번호(member_pw)
  - 영문 대/소문자, 숫자, 특수문자 중 !, @, #, $를 사용 가능
  - 반드시 1개에 대한 조건은 크게 고려하지 말것(표현 방식이 다름)
  - 8~20글자로 설정
- 회원 닉네임(member_nickname)
  - 다른 회원들과 중복되지 않는 고유한 값
  - 영문 대/소문자, 숫자, 완성된 한글로 이루어진 2~10글자
- 회원 생년월일(member_birth)
  - YYYY-MM-DD 형식의 값
- 회원 이메일(member_email)
  - 100byte 이내로 설정하며 특별한 형식 검사를 하지 않음
  - 사용자가 입력하지 않을 수 있음
- 회원 전화번호(member_contact)
  - 휴대전화번호 형식이며 대시를 허용하지 않음
- 회원 등급(member_level)
  - 일반/VIP/관리자 셋 중 하나를 지정할 수 있음
  - 미지정시 일반으로 설정됨
- 회원 포인트(member_point)
  - 미지정시 0으로 설정됨
  - 0 이상으로만 설정 가능
- 회원 가입일(member_join)
  - 회원이 가입할 당시의 시각
  - 미 지정시 현재 시각으로 설정됨
*/

--(주의) 오라클에는 긍정탐색, 부정탐색이 없다
drop table member;
create table member(
member_id varchar2(25) primary key,
member_pw varchar2(20) not null,
member_nickname varchar2(30) not null,
member_birth char(10) not null unique,
member_email varchar2(100),
member_contact varchar2(11) not null,
member_level varchar2(9) default '일반' not null,
member_point number default 0 not null,
member_join date default sysdate not null,
check(regexp_like(member_id, '^[a-z][a-z0-9]{7,24}$')),
check(
	regexp_like(member_pw, '[A-Z]+') 
	and
	regexp_like(member_pw, '[a-z]+')
	and
	regexp_like(member_pw, '[0-9]+')
	and
	regexp_like(member_pw, '[!@#$]+')
	and
	regexp_like(member_pw, '^[A-Za-z0-9!@#$]{8,20}$')
),
check(regexp_like(member_nickname, '^[A-Za-z0-9가-힣]{2,10}$')),
check(regexp_like(member_birth, '^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$')),
check(regexp_like(member_contact, '^01[016789][1-9][0-9]{2,3}[0-9]{4}$')),
check(member_level in ('일반', 'VIP', '관리자')),
check(member_point >= 0)
);

insert into member(
	member_id, member_pw, member_nickname, 
	member_birth, member_email, member_contact
)
values(
	'testuser1', 'Testuser1!', '테스트유저1', 
	'2023-07-19', null, '01012345678'
);

select * from member;
