<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>

<!-- favicon 설정 -->
<link rel="shortcut icon" href="/images/favicon.ico">

<!--icon을 사용하기 위한 Font Awesome 6 CDN(Content Delivery Network, 네트워크를 통한 컨텐츠 전달 방식)-->
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<!-- 스타일시트 로딩 코드  -->
<link  rel="stylesheet" type="text/css" href="/css/reset.css">
<link  rel="stylesheet" type="text/css" href="/css/layout.css">
<link  rel="stylesheet" type="text/css" href="/css/commons.css">
<!-- <link  rel="stylesheet" type="text/css" href="/css/test.css"> -->
<style>
 .title{
 	flex-wrap:wrap;
 }
</style>
</head>
<body align="center">
    <main>
        <header class="header">
            <div class="logo">
                <img src="https://dummyimage.com/200x50/000/fff">
            </div>
            <div class="title">
            <div class="row w-100">
	            <h1>my hompage</h1>
            </div>
            <div class="row w-100">
	            <h3>
	   			<c:if test="${sessionScope.email!=null}">
					세션:${sessionScope.email}
					등급:${sessionScope.rank}
				</c:if>
	            </h3>
            </div>
            </div>
            <div class="etc">???</div>
        </header>
        <nav>
            <ul class="menu">
            	<c:choose>
            		<c:when test="${sessionScope.email ==null}">
            			<li><a href="/">홈</a></li>
            			<li><a href="/member/login">로그인</a></li>
            			<li><a href="/member/join">회원가입</a></li>
            			<li><a href="/board/list">게시판</a></li>
            		</c:when>
            		<c:otherwise>
            		    <li><a href="/">홈</a></li>
            			<li><a href="/member/mypage">마이페이지</a></li>
            			<li><a href="/member/logout">로그아웃</a></li>
            			<li><a href="/board/list">게시판</a></li>
            			<c:if test="${sessionScope.rank=='관리자'}">
						<li><a href="/admin/home">[관리자메뉴]</a></li>
						</c:if>	
            		</c:otherwise>
            	</c:choose>
            </ul>
        </nav>
        <section>
        	