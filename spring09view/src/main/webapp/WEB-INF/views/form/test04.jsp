<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="http://localhost:8080/member/join">
		회원 아이디:<input name="memberId"><br><br>
		회원 비밀번호:<input name="memberPw"><br><br>
		회원 닉네임:<input name="memberNickname"><br><br>
		회원 생일:<input name="memberBirth"><br><br>
		회원 이메일:<input name="memberEmail"><br><br>
		회원 전화번호:<input name="memberContact"><br><br>
		<button>등록</button>
	</form>
</body>
</html>