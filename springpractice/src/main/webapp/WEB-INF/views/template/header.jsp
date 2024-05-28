<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<!-- 스타일시트 로딩 코드  -->
<link  rel="stylesheet" type="text/css" href="/css/commons.css">
<!-- <link  rel="stylesheet" type="text/css" href="/css/test.css"> -->
<link  rel="stylesheet" type="text/css" href="/css/reset.css">
</head>
<body align="center">
		<main>
			<h1>my homepage</h1>
			<c:if test="${sessionScope.email!=null}">
				세션:${sessionScope.email}
				등급:${sessionScope.rank}
			</c:if>
			<hr>
	
				<c:choose>
					<c:when test="${sessionScope.email ==null}">
						<a class="btn" href="/">홈</a>
						<a class="btn" href="/member/login">로그인</a>
						<a class="btn" href="/member/join">회원가입</a>
						<a class="btn" href="/board/list">게시판</a>
					</c:when>
					<c:otherwise>
						<a class="btn" href="/">홈</a>
						<a class="btn" href="/member/mypage">마이페이지</a>
						<a class="btn" href="/member/logout">로그아웃</a>
						<a class="btn" href="/board/list">게시판</a>
						<!-- 관리자일 경우 관리자메뉴 링크 생성 -->
						<c:if test="${sessionScope.rank=='관리자'}">
						<a class="btn" href="/admin/home">[관리자메뉴]</a>
						</c:if>					
					</c:otherwise>
				</c:choose>

       		<section>		