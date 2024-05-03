<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div align="center">
		<h1>my homepage</h1>
		<c:if test="${sessionScope.email!=null}">
			세션:${sessionScope.email}
			등급:${sessionScope.rank}
		</c:if>
		<hr>

			<c:choose>
				<c:when test="${sessionScope.email ==null}">
					<a href="/">홈</a>
					<a href="/member/login">로그인</a>
					<a href="/member/join">회원가입</a>
					<a href="/board/list">게시판</a>
				</c:when>
				<c:otherwise>
					<a href="/">홈</a>
					<a href="/member/mypage">마이페이지</a>
					<a href="/member/logout">로그아웃</a>
					<a href="/board/list">게시판</a>
					<!-- 관리자일 경우 관리자메뉴 링크 생성 -->
					<c:if test="${sessionScope.rank=='관리자'}">
					<a href="/admin/home">[관리자메뉴]</a>
					</c:if>					
				</c:otherwise>
			</c:choose>
		<hr>