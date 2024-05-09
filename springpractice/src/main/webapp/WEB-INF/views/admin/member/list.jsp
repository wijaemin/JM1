<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>회원 관리</h2>

<form action="list" method="get">

	<c:choose>
		<c:when test="${vo.type=='nickname'}">
			<select name="type">
				<option value="email">아이디</option>
				<option value="nickname" selected>닉네임</option>
				<option value="contact">전화번호</option>
				<option value="birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type=='contact'}">
			<select name="type">
				<option value="email">아이디</option>
				<option value="nickname">닉네임</option>
				<option value="contact" selected>전화번호</option>
				<option value="birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type=='birth'}">
			<select name="type">
				<option value="email">아이디</option>
				<option value="nickname">닉네임</option>
				<option value="contact">전화번호</option>
				<option value="birth" selected>생년월일</option>
			</select>			
		</c:when>
		<c:otherwise>
			<select name="type">
				<option value="email">아이디</option>
				<option value="nickname">닉네임</option>
				<option value="contact">전화번호</option>
				<option value="birth">생년월일</option>
			</select>
		</c:otherwise>
	</c:choose>
	<input type="search" name= "keyword" placeholder="검색어" required>
	<button>검색</button>
</form>

<table border="1" width="800">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>비밀번호</th>
			<th>생년월일</th>
			<th>등급</th>
			<th>메뉴</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="memberDto" items="${list}">
			<tr>
				<td>${memberDto.email}</td>
				<td>${memberDto.nickname}</td>
				<td>${memberDto.contact}</td>
				<td>${memberDto.birth}</td>
				<td>${memberDto.rank}</td>
				<td>
					<a href="detail?email=${memberDto.email}">상세</a>
					<a href="edit?email=${memberDto.email}">수정</a>
					<a href="#">차단</a>
				</td>
			</tr>	
		</c:forEach>
	</tbody>
</table>

<h3>
<c:if test="${!vo.first}">
	<a href="list?${vo.prevQueryString}">&lt;</a>
</c:if>
<c:forEach var="i" begin="${vo.begin}" end="${vo.end}" step="1">
	<a href="list?${vo.getQueryString(i)}">${i}</a>
</c:forEach>
<c:if test="${!vo.last}">
	<a href="list?${vo.nextQueryString}">&gt;</a>
</c:if>


</h3>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>