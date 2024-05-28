<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class="container w-800">
	<div class="row">
		<h2>회원 관리</h2>
	</div>
	<table class="table table-border">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>비밀번호</th>
				<th>생년월일</th>
				<th>등급</th>
				<th>차단</th>
				<th>메뉴</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="memberListDto" items="${list}">
				<tr>
					<td>${memberListDto.email}</td>
					<td>${memberListDto.nickname}</td>
					<td>${memberListDto.contact}</td>
					<td>${memberListDto.birth}</td>
					<td>${memberListDto.rank}</td>
					<td>${memberListDto.block}</td>
					<td>
						<a href="detail?email=${memberListDto.email}">상세</a>
						<a href="edit?email=${memberListDto.email}">수정</a>
						<c:choose>
							<c:when test="${memberListDto.block=='Y'}">
								<a href="cancel?email=${memberListDto.email}">해제</a>
							</c:when>
							<c:otherwise>
								<a href="block?email=${memberListDto.email}">차단</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	
	<div class="row page-navigator">
	
		<c:if test="${!vo.first}">
			<a href="list?${vo.prevQueryString}">&lt;</a>
		</c:if>
		
		<c:forEach var="i" begin="${vo.begin}" end="${vo.end}" step="1">
			<c:choose>
				<c:when test="${vo.page==i}">
					<a class="on">${i}</a>
				</c:when>
				<c:otherwise>
					<a href="list?${vo.getQueryString(i)}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${!vo.last}">
			<a href="list?${vo.nextQueryString}">&gt;</a>
		</c:if>
		
	</div>
	<form action="list" method="get">
		<div class="row">
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
		<input type="search" name= "keyword" class="form-input" placeholder="검색어" required>
		<button class="btn btn-positive">검색</button>
		</div>
	</form>

</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>