<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h2>${memberDto.nickname}님의 정보</h2>
	
	<table border="1" width="600">
	
		<tr>
			<th>이메일</th>
			<td>${memberDto.email}</td>
		</tr>
		<tr>
			<th>전화번호</th>
<%-- 			<td>${memberDto.contact}</td> --%>
			<td>
				<c:set var="phone" value="${memberDto.contact}"/>
				<c:if test="${memberDto.contact!=null}">
					<c:set var="formattedPhone" value="${fn:substring(phone, 0, 3)}-${fn:substring(phone, 3, 7)}-${fn:substring(phone, 7, 11)}"/>
					${formattedPhone}
				</c:if>
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${memberDto.birth}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				[${memberDto.post}]
				${memberDto.addr1}
				${memberDto.addr2}
			</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${memberDto.rank}</td>
		</tr>
		<tr>
			<th>포인트</th>
			<td>
				<fmt:formatNumber value="${memberDto.point}" pattern="#,##0">
				</fmt:formatNumber>pt
			</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>
				<fmt:formatDate value="${memberDto.joinAt}" 
				pattern="y년 M월 d일 E a h시 m분 s초"/>
			</td>
		</tr>
		<tr>
			<th>최근 접속일</th>
			<td>
				<fmt:formatDate value="${memberDto.loginAt}" 
				pattern="y년 M월 d일 E a h시 m분 s초"/>
			</td>
		</tr>
	
	
	</table>
	
	<h2><a href="changePw">비밀번호 변경</a></h2>
	<h2><a href="changeInfo">개인정보 변경</a></h2>
	<h2><a href="exit">계정 탈퇴</a></h2>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>