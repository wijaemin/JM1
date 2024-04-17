<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h2>비밀번호 변경</h2>
	<form action="changePw" method="post">
	현재 비밀번호<input type="password" name="originPw" required><br><br>
	새 비밀번호<input type="password" name="changePw" required><br><br>
	<button>비밀번호 변경</button>
	</form>
	
	<c:if test="${param.error != null}">
		<h2>현재 비밀번호가 일치하지 않습니다</h2>	
	</c:if>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>