<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	
	<div class="container w-400">
		<div class="row">
			<h1>회원 탈퇴</h1>
		</div>
		<div class="row">
		<h2>정말 탈퇴 할껍니까?</h2>
		</div>
		<div class="row center">
			<img class="row" src="/images/sad.gif" width="300">
		</div>
		<form action="exit" method="post">
			<div class="row left">
			<label>비밀번호 입력</label>
			<input class="form-input w-100" type="password" name="memberPw"><br><br>
			</div>
				
		
			<button class="btn">탈퇴..하기</button>
		</form>
		<c:if test="${param.error !=null}">
		<h1>비밀번호 잘못 입력했어요</h1>
		</c:if>
	</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>