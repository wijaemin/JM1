<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>
	<h1>도서 목록</h1>
	<h1><a href="insert">도서 등록</a></h1>
		<table border="1" width="1000">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>출간일</th>
				<th>가격</th>
				<th>출판사</th>
				<th>페이지수</th>
				<th>장르</th>
				<th>삭제</th>
				
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="dto"  items= "${list}">
			<tr>
				<td>${dto.bookId}</td>
				<td align="left">
					<a href="detail?bookId=${dto.bookId}">
				${dto.bookTitle}
					</a>
				</td>
				<td>${dto.bookAuthor}</td>
				<td>${dto.bookPublicationDate}</td>
				<td>${dto.bookPrice}</td>
				<td>${dto.bookPublisher}</td>
				<td>${dto.bookPageCount}</td>
				<td>${dto.bookGenre}</td>
				<td>
				<a href="delete?bookId=${dto.bookId}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		
		
		
		
		
		
		
		</table>

</body>
</html>