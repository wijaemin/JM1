<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
	<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<h1>환영합니다</h1>
	<img src="/images/faker3.jpg" width="300" height="200">


	<form id="quickLogin" action="/member/login" method="post">
    <input type="hidden" name="email" value="admin1234@naver.com">
    <input type="hidden" name="password" value="Admin1234!!">
    <button type="submit">간단 로그인</button>
	</form>
	<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>