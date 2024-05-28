<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<form action="changePw" method="post">
		<div class="container w-500">
			<div class="row">
				<h2>비밀번호 변경</h2>
			</div>
			<div class="row left">
				<label>현재 비밀번호</label>
				<input type="password" name="originPw" class="form-input w-100" required>
			</div>
			<div class="row left">
				<label>새 비밀번호</label>
				<input type="password" name="changePw" class="form-input w-100" required>
			</div>
			<div class="row">
				<button class="btn btn-positive">비밀번호 변경</button>
			</div>
		</div>
	</form>
	
	<c:if test="${param.error != null}">
		<div class="row">
			<h2>현재 비밀번호가 일치하지 않습니다</h2>	
		</div>
	</c:if>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>