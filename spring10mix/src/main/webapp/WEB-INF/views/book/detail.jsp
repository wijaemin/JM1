<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.bookId}번 책 상세조회</title>
</head>
<body>
	<c:choose>
	<c:when test="${dto!=null}">
	
	<h1>${dto.bookId}번 책 상세조회</h1>
	<!-- 
		리스트 태그
		-외부에<ul> 또는 <ol>을 사용
			-ul은 순서가 없는 리스트(unorder list)
			-ol은 순서가 있는 리스트(order list)
		-내부 항목에<li>를 사용(list item)
	 -->
<!-- 	 <ul> -->
<%-- 	 	<li>${dto.bookId}</li> --%>
<%-- 	 	<li>${dto.bookTitle}</li> --%>
<%-- 	 	<li>${dto.bookAuthor}</li> --%>
<%-- 	 	<li>${dto.bookPublicationDate}</li> --%>
<%-- 	 	<li>${dto.bookPrice}</li> --%>
<%-- 	 	<li>${dto.bookPublisher}</li> --%>
<%-- 	 	<li>${dto.bookPageCount}</li> --%>
<%-- 	 	<li>${dto.bookGenre}</li> --%>
	 
<!-- 	 </ul> -->
	<table border="1" width ="600">
	<tr>
	<th width="100">책 제목</th>
	
	<td width ="300">${dto.bookTitle}</td>
	<td rowspan="7" ><img src ="/tom and jerry.jpg">
	</td>
	</tr>
	
	<tr>
	<th>책 저자</th>
	
	<td>${dto.bookAuthor}</td>
	</tr>
	
	<tr>
	<th>책 출판일</th>
	
	<td>${dto.bookPublicationDate}</td>
	</tr>
	
	<tr>
	<th>책 가격</th>
	
	<td>${dto.bookPrice}</td>
	</tr>
	
	<tr>
	<th>책 출판사</th>
	
	<td>${dto.bookPublisher}</td>
	</tr>
	
	<tr>
	<th>책 페이지 수</th>
	
	<td>${dto.bookPageCount}</td>
	</tr>
	
	<tr>
	<th>책 장르</th>
	
	<td>${dto.bookGenre}</td>
	</tr>

	
	</table>
	</c:when>
	<c:otherwise>
	<h1>니가 찾는 책번호는 없어</h1>
	<img width ="300" height="300" src="/sorry.gif">
	</c:otherwise>
	</c:choose>
<%-- 	<c:if test="${not empty dto}"> --%>
	<c:if test="${dto!=null}">
	<h2><a href="edit?bookId=${dto.bookId}">도서 수정하러 가기</a></h2>
	<h2><a href="delete?bookId=${dto.bookId}">삭제해버리기</a></h2>
	</c:if>
	
<a href ="list">
<h2>목록으로 이동</h2>
</a>
</body>
</html>