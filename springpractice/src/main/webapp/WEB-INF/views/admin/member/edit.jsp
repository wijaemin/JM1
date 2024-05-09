<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<h2>회원 정보 변경</h2>
	
	<form action="edit" method="post">
		<input type="hidden" name="email" value="${memberDto.email}">
		닉네임<input type="text" name="nickname" value="${memberDto.nickname}" required><br><br> 
		전화번호<input type="tel" name="contact" value="${memberDto.contact}" required><br><br>
		주소<br>
		<input type="text" name="post" value="${memberDto.post}" placeholder="우편번호"><br>
		<input type="text" name="addr1" value="${memberDto.addr1}" placeholder="기본주소"><br>
		<input type="text" name="addr2" value="${memberDto.addr2}" placeholder="상세주소"><br><br>
		
		등급
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

		포인트 <input type="text" name="point" value="${memberDto.point}"><br><br>
		<button>수정하기</button>
	</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>