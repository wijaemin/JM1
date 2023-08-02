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
	<table border="1" width ="500">
	<tr>
	<th width="25%">책 제목</th>
	
	<td>${dto.bookTitle}</td>
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
	</c:otherwise>
	</c:choose>
	
	

</body>
</html>