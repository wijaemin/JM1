<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>로그인</h1>
<form action="login" method="post">
	<input type="text" name="email" placeholder="이메일" required><br><br>
	<input type="password" name="password" placeholder="비밀번호" required><br><br>
	<button>Login</button>
</form>

<c:if test="${param.error != null}">
	<h2>아이디 또는 비밀번호가 일치하지 않습니다</h2>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>