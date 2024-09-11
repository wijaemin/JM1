<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<style>
    input[name=addr1]{
        border-bottom: none;
    }
    </style>	
	<form action="edit" method="post">
		<div class="container w-400">
			<div class="row">
				<h2>회원 정보 변경</h2>
			</div>
		<input type="hidden" name="email"  value="${memberDto.email}">
		<div class="row left">
			<label>닉네임</label>
			<input type="text" name="nickname" class="form-input w-100" value="${memberDto.nickname}" required>
		</div>
		<div class="row left">
			<label>전화번호</label>
			<input type="tel" name="contact" class="form-input w-100" value="${memberDto.contact}">
		</div>
		<div class="row left">
			<label style="display: block;">주소</label>
			<input type="text" name="post" class="form-input w-100" value="${memberDto.post}" placeholder="우편번호">
		</div>
		<div class="row">
			<input type="text" name="addr1" class="form-input w-100" value="${memberDto.addr1}" placeholder="기본주소">
			<input type="text" name="addr2" class="form-input w-100" value="${memberDto.addr2}" placeholder="상세주소">
		</div>
		
		<div class="row">
		<label>등급</label>
		<c:choose>
			<c:when test="${memberDto.rank=='일반'}">
				<input type="radio" name="rank" value="일반" checked>일반
				<input type="radio" name="rank" value="VIP">VIP
				<input type="radio" name="rank" value="관리자">관리자			
			</c:when>
			<c:when test="${memberDto.rank=='VIP'}">
				<input type="radio" name="rank" value="일반">일반
				<input type="radio" name="rank" value="VIP" checked>VIP
				<input type="radio" name="rank" value="관리자">관리자
			</c:when>
			<c:otherwise>
				<input type="radio" name="rank" value="일반">일반
				<input type="radio" name="rank" value="VIP">VIP
				<input type="radio" name="rank" value="관리자" checked>관리자
			</c:otherwise>
		</c:choose><br><br>
		</div>

		<div class="row left">
			<label>포인트</label>
			<input type="text" name="point" class="form-input w-100" value="${memberDto.point}">
		</div>
		<button class="btn btn-positive w-100">수정하기</button>
		</div>
	</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>