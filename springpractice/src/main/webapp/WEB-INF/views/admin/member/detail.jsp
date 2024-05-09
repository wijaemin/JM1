<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


	<h2>${memberDto.nickname}(${memberDto.email})의 상세 정보</h2>
	
	<table border="1" width="600">
		<tr>
			<th>전화번호</th>
			<td>
				<c:set var="phone" value="${memberDto.contact}"/>
					<c:if test="${memberDto.contact != null}">
						<c:set var="formattedPhone" value="${fn:substring(phone,0,3)}-${fn:substring(phone,3,7)}-${fn:substring(phone,7,11)}"/>
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
			<td>${memberDto.point}</td>
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
	
	<h2>활동 내역</h2>
	<table border="1" width="500">
		<thead>
			<tr>
				<th width="75%">제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="boardListDto" items="${boardList}">
				<tr>
					<td>
						<a href="/board/detail?no=${boardListDto.no}">
						${boardListDto.title}
						</a>
					</td>
					<td>${boardListDto.createdAt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>