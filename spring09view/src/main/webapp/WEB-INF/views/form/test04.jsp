<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="http://localhost:8080/member/join">
	회원 아이디:<input type="text" name="memberId" required><br><br>
	회원 비밀번호:<input type="text" name="memberPw" required><br><br>
	회원 닉네임:<input type="text" name="memberNickname" required><br><br>
	회원 생년월일:<input type="date" name="memberBirth" required><br><br>
	회원 이메일:<input type="text" name="memberEmail"><br><br>
	회원 전화번호<input type="text" name="memberContact" required><br><br>
	<button>등록하기</button>
	
	</form>
	
	
	
</body>
</html>