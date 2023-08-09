<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>회원탈퇴</h1>
	<h2>정말 탈퇴 할껍니까?</h2>
	<img src="/sad.gif">
	<form action="exit" method="post">
	
		비밀번호 입력<input type="password" name="inputPw"><br><br>	
	
		<button>탈퇴..하기</button>
	</form>
	<c:if test="${param.error !=null}">
	<h1>비밀번호 잘못 입력했어요</h1>
	</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>