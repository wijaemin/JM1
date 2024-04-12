<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원가입</h1>
	<form action="join" method="post" autocomplete="off">
		이메일<input type="email" name="email" required><br><br>
		비밀번호<input type="password" name="password" required><br><br>
		닉네임<input type="text" name="nickname" required><br><br>
		전화번호<input type="tel" name="contact" required><br><br>
		생년월일<input type="date" name="birth"><br><br>
		주소<br>
		<input type="text" name="post" placeholder="우편번호" size="6" maxlength="6"><br>
		<input type="text" name="addr1" placeholder="기본주소"><br>
		<input type="text" name="addr2" placeholder="상세주소"><br>
		
		<button>가입하기</button>
	</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>