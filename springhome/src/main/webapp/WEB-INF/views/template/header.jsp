<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>
	
	
	
	<div align="center">
	
	
	<h1 >(●'◡'●)내가 만든 홈페이지(●'◡'●)</h1>
	<h3 align="right">아이디 : ${sessionScope.name}</h3>
	<h3 align="right">비밀번호 : ${sessionScope.value}</h3>
	
	<hr>
	<%--
		JSP에서 세션에 저장된 값을 확인하려면 EL의 내장객체를 사용
		sessionScope 내장객체를 사용하면 HttpSession의 값을 조회할 수 있다
	 --%>
	 	세션ID=${pageContext.session.id},
	 	세션값=${sessionScope.name}<br>
	<%--
		이 페이지는 조각일 뿐이므로 어디서 실행될지 모른다
		여기서 작성되는 경로는 무조건 절대경로여야 한다
	 --%>
	 
	 	<c:choose>
	 		<c:when test="${sessionScope.name !=null}">
				<a href="/">홈</a>
				<a href="/member/mypage">마이페이지</a>
	 			<a href="/member/logout">로그아웃</a>
	 			<a href="/board/list">게시판</a>
	 		</c:when>
	 		<c:otherwise>
				<a href="/">홈</a>
				<a href="/member/join">회원가입</a>
				<a href="/member/login">로그인</a>
				<a href="/board/list">게시판</a>
	 		</c:otherwise>
	 	</c:choose>
	<hr>