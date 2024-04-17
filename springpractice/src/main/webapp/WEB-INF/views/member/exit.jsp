<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h2>회원 탈퇴</h2>
	<h3>정말 탈퇴하시겠습니까?</h3>
	<form action="exit" method="post">
		비밀번호<input type="password" name="password" required><br><br>
	
		<button>탈퇴하기</button>
	</form>
	
	<c:if test="${param.error !=null}">
		<h2 style="color : red;">비밀번호가 일치하지 않습니다</h2>
	</c:if>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>